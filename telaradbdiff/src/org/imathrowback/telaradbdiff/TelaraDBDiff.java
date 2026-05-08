package org.imathrowback.telaradbdiff;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import org.imathrowback.datparser.DataModel;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.imathrowback.manifest.Versions;
import org.imathrowback.telaradb.TelaraDB;
import org.imathrowback.telaradb.TelaraDBUtil;
import org.imathrowback.telaradbdiff.diff.*;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

import com.google.common.io.Files;

import rift_extractor.EnglishLang;

public class TelaraDBDiff
{
	@Option(name = "-json", usage = "Use JSON instead of XML", required = false)
	boolean json = false;

	@Option(name = "-dbA", usage = "First database", required = true)
	File dba;

	@Option(name = "-dbResolve", usage = "Name resolution database", required = false)
	File dbResolve;

	//@Option(name = "-releaseA", usage = "Release type, needed if -autoDownload is specified")
	//ReleaseType releaseTypeA;

	//@Option(name = "-releaseB", usage = "Release type, needed if -autoDownload is specified")
	//ReleaseType releaseTypeB;

	@Option(name = "-dbB", usage = "Second database", required = true)
	File dbb;

	@Option(name = "-autoDownload", usage = "Tries to automatically download the language databases. Will override langA and langB options", required = false)
	boolean autoDownloadLangDB = false;

	@Option(name = "-langA", usage = "First language database", required = false)
	File langA;

	@Option(name = "-langB", usage = "Second language database", required = false)
	File langB;

	@Option(name = "-outdir", usage = "Output directory for differences", required = true, metaVar = "DIR")
	File outdir = null;
	@Option(name = "-64")
	boolean is64 = true;

	@Option(name = "-format", usage = "Output format: text or html", required = false)
	String formatStr = "text";

	@Option(name = "-output", usage = "Write report to file instead of stdout", required = false)
	String outputFile = "";

	public static void main(final String[] args)
	{
		new TelaraDBDiff().go(args);
	}

	public void go(final String[] args)
	{
		CmdLineParser parser = new CmdLineParser(this);
		parser.setUsageWidth(80);
		try
		{
			parser.parseArgument(args);
			if (!outdir.isDirectory())
				throw new CmdLineException(parser, "Output must be a directory");

		} catch (CmdLineException e)
		{
			System.err.println(e.getMessage());
			System.err.println("java TelaraDBDiff [options...] arguments...");
			parser.printUsage(System.err);
			System.err.println();
			System.err.println("  Example: java TelaraDBDiff" + parser.printExample(OptionHandlerFilter.ALL));
			return;
		}
		try
		{
			doDiff();
		} catch (UnsatisfiedLinkError ex)
		{
			if (ex.getMessage().contains("32-bit"))
				System.err.println(
						"Due to technical limitations this program will only work with a 32-bit Java Virtual Machine");
			else
				ex.printStackTrace();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private static void transmog(final CObject obj, final EnglishLang lang)
	{
		if (obj.extracode == obj.index)
			obj.extracode = null;
		if (obj.members.size() == 0)
		{
			Object o = obj.convert();
			if (o instanceof Long)
			{
				obj.longValue = (Long) o;
				obj.objData = null;
				return;
			} else if (o instanceof Integer)
			{
				obj.intValue = (Integer) o;
				obj.objData = null;
				return;
			} else if (o instanceof String && !((String) o).isEmpty())
			{
				obj.stringValue = (String) o;
				obj.objData = null;
				return;
			}
		}
		if (obj.type == 7703)
		{
			if (!(obj.objData instanceof String) && !(obj.get(0).objData instanceof String))
			{
				// replace the child with an appropriate lang english ref
				int key = Integer.parseInt("" + obj.get(0).convert());
				obj.members.clear();
				obj.objData = lang.getText(key);
			}
		} else
			for (CObject o : obj.members)
				transmog(o, lang);
	}

	EnglishLang langAdb = null;
	EnglishLang langBdb = null;

	void doDiff() throws Exception
	{
		doDecrypt();

		if (autoDownloadLangDB)
		{
			ReleaseType releaseTypeB = Versions.getVersion(1, is64).getRelease();
			ReleaseType releaseTypeA = Versions.getVersion(0, is64).getRelease();
			RemotePAK.download(releaseTypeA, 'A', "lang_english.cds", "lang_english.cdsA", outdir.toString(), is64);
			RemotePAK.download(releaseTypeB, 'B', "lang_english.cds", "lang_english.cdsB", outdir.toString(), is64);
		}
		if (langA != null && langA.exists())
		{
			System.out.println("Loading english language DB(a) " + langA);
			langAdb = new EnglishLang(java.nio.file.Files.readAllBytes(langA.toPath()));
		}
		if (langB != null && langB.exists())
		{
			System.out.println("Loading english language DB(b) " + langB);
			langBdb = new EnglishLang(java.nio.file.Files.readAllBytes(langB.toPath()));
		}

		System.out.println("loading databases");
		TelaraDB fileA = new TelaraDB(java.sql.DriverManager.getConnection("jdbc:sqlite:" + dba.getPath()));
		TelaraDB fileB = new TelaraDB(java.sql.DriverManager.getConnection("jdbc:sqlite:" + dbb.getPath()));

		Set<Pair<Integer, Integer>> idsA = fileA.getIdsAndKeys()
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
		Set<Pair<Integer, Integer>> idsB = fileB.getIdsAndKeys()
				.collect(Collectors.toCollection(() -> new TreeSet<>()));

		System.out.println("loaded " + idsA.size() + " entries from A, " + idsB.size() + " from B");

		DataModel dataModel = new DataModel(dbResolve);
		DbDiffResult result = new DbDiffResult();
		result.setTotalOld(idsA.size());
		result.setTotalNew(idsB.size());

		System.out.println("finding deletions...");
		for (Pair<Integer, Integer> idA : idsA)
		{
			if (!idsB.contains(idA))
			{
				result.addEntry(new DbDiffEntry(idA.getLeft(), idA.getRight(),
						DbDiffEntry.ChangeType.DELETED, null, null, null, null));
			}
		}

		System.out.println("finding additions/changes...");
		int totalCount = idsB.size();
		AtomicInteger count = new AtomicInteger();
		AtomicInteger lastP = new AtomicInteger();

		idsB.parallelStream().forEach(idB -> {
			try
			{
				int id = idB.getLeft();
				int key = idB.getRight();

				if (!idsA.contains(idB))
				{
					byte[] data = fileB.getData(id, key);
					CObject obj = DatParser.processFileAndObject(new ByteArrayInputStream(data), dataModel);
					obj.index = id;
					obj.extracode = key;

					if (langBdb != null)
						transmog(obj, langBdb);

					Path newDir = Paths.get(outdir.toString(), "db", "new");
					newDir.toFile().mkdirs();
					Files.write(data, Paths.get(newDir.toString(), id + "_" + key + ".dat").toFile());

					synchronized (result)
					{
						result.addEntry(new DbDiffEntry(id, key, DbDiffEntry.ChangeType.ADDED,
								null, obj, null, data));
					}
				} else
				{
					byte[] dataA = fileA.getCompressedData(id, key);
					byte[] dataB = fileB.getCompressedData(id, key);
					if (!Arrays.equals(dataA, dataB))
					{
						CObject objA = DatParser.processFileAndObject(
								new ByteArrayInputStream(fileA.decompressData(id, dataA)), dataModel);
						CObject objB = DatParser.processFileAndObject(
								new ByteArrayInputStream(fileB.decompressData(id, dataB)), dataModel);

						if (langAdb != null)
							transmog(objA, langAdb);
						if (langBdb != null)
							transmog(objB, langBdb);

						List<FieldChange> changes = CObjectDiffer.diff(objA, objB);
						if (!changes.isEmpty())
						{
							synchronized (result)
							{
								result.addEntry(new DbDiffEntry(id, key, DbDiffEntry.ChangeType.CHANGED,
										objA, objB, changes, null));
							}
						}
					}
				}
			} catch (Exception ex)
			{
				System.err.println("Error processing entry:" + idB);
				ex.printStackTrace();
			} finally
			{
				int c = count.incrementAndGet();
				int per = (int) (((float) c / (float) totalCount) * 100.0f);
				int last = lastP.get();
				if (last != per && lastP.compareAndSet(last, per))
				{
					if ((per % 5) == 0)
						System.out.print(per + "%");
					else
						System.out.print(".");
				}
			}
		});

		System.out.println("\nwriting report...");

		DbDiffOutput.Format format;
		if ("html".equalsIgnoreCase(formatStr))
			format = DbDiffOutput.Format.HTML;
		else
			format = DbDiffOutput.Format.TEXT;

		if (!outputFile.isEmpty())
		{
			DbDiffOutput.writeReport(result, format, new File(outputFile));
			System.out.println("Report written to " + outputFile);
		} else
		{
			System.out.print(DbDiffOutput.format(result, format));
		}
	}

	static boolean isSQL(final byte[] header)
	{
		return header[0] == 'S' && header[1] == 'Q' && header[2] == 'L';
	}

	static boolean isSQL(final File file) throws IOException
	{
		byte[] header = new byte[16];
		try (FileInputStream fis = new FileInputStream(file))
		{
			fis.read(header);
			return isSQL(header);
		}
	}

	private void doDecrypt() throws Exception
	{
		if (!isSQL(dba))
		{
			System.out.println("fileA [" + dba + "] is either encrypted or not a SQL database, attempting decrypt.");
			tryDecrypt(dba);
			if (!isSQL(dba))
				throw new Exception("File A [" + dba + "] does not appear to be an SQL database");
		}
		if (!isSQL(dbb))
		{
			System.out.println("fileB [" + dbb + "] is either encrypted or not a SQL database, attempting decrypt.");
			tryDecrypt(dbb);
			if (!isSQL(dbb))
				throw new Exception("File B [" + dbb + "] does not appear to be an SQL database");
		}
	}

	private void tryDecrypt(final File encryptedFile) throws Exception
	{
		byte[] data = java.nio.file.Files.readAllBytes(encryptedFile.toPath());
		byte[] decrypted = new byte[data.length];
		TelaraDBUtil.decrypt(data, data.length, decrypted);
		Files.write(decrypted, encryptedFile);
	}
}
