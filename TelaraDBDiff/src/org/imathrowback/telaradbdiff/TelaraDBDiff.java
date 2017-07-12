package org.imathrowback.telaradbdiff;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.imathrowback.telaradb.TelaraDB;
import org.imathrowback.telaradb.TelaraDBUtil;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

import com.google.common.io.Files;
import com.sksamuel.diffpatch.DiffMatchPatch.Diff;
import com.thoughtworks.xstream.XStream;

import rift_extractor.EnglishLang;

public class TelaraDBDiff
{
	@Option(name = "-dbA", usage = "First database", required = true)
	File dba;

	@Option(name = "-release", usage = "Release type, needed if -autoDownload is specified")
	ReleaseType releaseType;
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

			// parse the arguments.
			parser.parseArgument(args);
			if (!outdir.isDirectory())
				throw new CmdLineException(parser, "Output must be a directory");
			if (autoDownloadLangDB && releaseType == null)
				throw new CmdLineException(parser, "Release type must be specified in addition to auto download");

		} catch (CmdLineException e)
		{
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			System.err.println("java TelaraDBDiff [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// print option sample. This is useful some time
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

	void doDiff() throws Exception
	{
		doDecrypt();

		EnglishLang langAdb = null;
		EnglishLang langBdb = null;

		if (autoDownloadLangDB)
		{
			RemotePAK.download(releaseType, 'A', "lang_english.cds", outdir.toString());
			RemotePAK.download(releaseType, 'B', "lang_english.cds", outdir.toString());
		}
		if (langA != null)
		{
			if (langA.exists())
			{
				System.out.println("Loading english language DB(a) " + langA);
				langAdb = new EnglishLang(java.nio.file.Files.readAllBytes(langA.toPath()));
			}
		}
		if (langB != null)
		{
			if (langB.exists())
			{
				System.out.println("Loading english language DB(b) " + langA);
				langBdb = new EnglishLang(java.nio.file.Files.readAllBytes(langB.toPath()));
			}
		}

		System.out.println("loading databases");

		TelaraDB fileA = new TelaraDB(DriverManager.getConnection("jdbc:sqlite:" + dba.getPath()));
		TelaraDB fileB = new TelaraDB(DriverManager.getConnection("jdbc:sqlite:" + dbb.getPath()));

		Set<Pair<Integer, Integer>> idsA = fileA.getIdsAndKeys()
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
		Set<Pair<Integer, Integer>> idsB = fileB.getIdsAndKeys()
				.collect(Collectors.toCollection(() -> new TreeSet<>()));

		System.out.println("loaded, now process diff");
		System.out.println("look for deletions");
		for (Pair<Integer, Integer> idA : idsA)
		{
			if (!idsB.contains(idA))
				System.out.println("deleted in B:" + idA);
		}
		System.out.println("look for additions/changes");
		try (PrintWriter newFos = new PrintWriter("new.xml"))
		{
			int totalCount = idsB.size();
			int count = 0;
			int lastP = 0;
			for (Pair<Integer, Integer> idB : idsB)
			{
				count++;
				int per = (int) (((float) count / (float) totalCount) * 100.0f);
				if (lastP != per)
				{
					if ((per % 5) == 0)
						System.out.print(per + "%");
					else
						System.out.print(".");
					lastP = per;
				}

				try
				{
					int id = idB.getLeft();
					int key = idB.getRight();
					if (!idsA.contains(idB))
					{
						//System.out.println("added in B:" + idB);
						CObject obj = DatParser
								.processFileAndObject(
										new ByteArrayInputStream(fileB.getData(idB.getLeft(), idB.getRight())));
						XStream str = new XStream();
						str.processAnnotations(CObject.class);
						str.toXML(obj, newFos);
						newFos.println("");
					} else
					{
						// check for changed
						byte[] dataA = fileA.getCompressedData(id, key);
						byte[] dataB = fileB.getCompressedData(id, key);
						if (!Arrays.equals(dataA, dataB))
						{
							XStream str = new XStream();
							str.processAnnotations(CObject.class);

							//System.out.println("changed:" + idB);
							CObject objA = DatParser
									.processFileAndObject(
											new ByteArrayInputStream(fileA.getData(idB.getLeft(), idB.getRight())));
							CObject objB = DatParser
									.processFileAndObject(
											new ByteArrayInputStream(fileB.getData(idB.getLeft(), idB.getRight())));

							if (langAdb != null)
								transmog(objA, langAdb);
							if (langBdb != null)
								transmog(objB, langBdb);

							String a = str.toXML(objA);
							String b = str.toXML(objB);
							if (!a.equals(b))
							{
								Path dbDir = Paths.get(outdir.toString(), "db");
								dbDir.toFile().mkdir();
								Path aPath = Paths.get(dbDir.toString(), id + "_" + key + ".a");
								Path bPath = Paths.get(dbDir.toString(), id + "_" + key + ".b");
								Path diffPath = Paths.get(dbDir.toString(), id + "_" + key + ".diff");

								Files.write(a, aPath.toFile(), Charset.forName("UTF-8"));
								Files.write(b, bPath.toFile(), Charset.forName("UTF-8"));

								ProcessBuilder diff = new ProcessBuilder("diff", "-d", aPath.toString(),
										bPath.toString());
								diff = diff.redirectOutput(diffPath.toFile());
								Process p = diff.start();
								p.waitFor();
								/*
								DiffMatchPatch dmp = new DiffMatchPatch();
								LinkedList<Diff> diffs = dmp.diff_main(a, b);
								dmp.diff_cleanupSemantic(diffs);
								String t = dmp.diff_toDelta(diffs);
								t = dmp.diff_prettyHtml(diffs);
								t = diff(diffs);
								changedFos.println(">>>>>>>" + idB);
								changedFos.println(t);
								changedFos.println("<<<<<<<<<<<");
								*/
							}

						}
					}
				} catch (Exception ex)
				{
					System.err.println("Error processing entry:" + idB);
				}
			}
		}
		System.out.println(
				"Done. See new.xml for any additions and " + Paths.get(outdir.toString(), "db") + " for changes.");

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

	public static String diff(final LinkedList<Diff> diffs)
	{
		StringBuilder html = new StringBuilder();
		for (Diff aDiff : diffs)
		{
			String text = aDiff.text;
			//String text = aDiff.text.replace("&", "&amp;").replace("<", "&lt;")
			//   .replace(">", "&gt;").replace("\n", "&para;<br>");
			switch (aDiff.operation)
			{
				case INSERT:
					html.append("+'").append(text).append("'");
					break;
				case DELETE:
					html.append("-'").append(text).append("'");
					break;
				case EQUAL:
					html.append(text);
					break;
			}
		}
		return html.toString();
	}

	static Set<Entry> getEntries(final String db)
	{

		try
		{
			Connection connection = DriverManager.getConnection("jdbc:sqlite:" + db);
			TelaraDB file = new TelaraDB(connection);
			Comparator<Entry> comp = Comparator.comparing(p -> p.id);
			comp = comp.thenComparing(Comparator.comparing(p -> p.key));

			Set<Entry> entries = Collections.synchronizedSet(new TreeSet<Entry>(comp));
			long total = file.getIds().count();
			AtomicInteger done = new AtomicInteger(0);
			file.getIdsAndKeys().parallel().forEach(p -> {
				Entry entry = new Entry();
				entry.id = p.getLeft();
				entry.key = p.getRight();
				entry.sortKey = entry.id + "-" + entry.key;
				try
				{
					entry.obj = DatParser
							.processFileAndObject(new ByteArrayInputStream(file.getData(p.getLeft(), p.getRight())));
				} catch (Exception ex)
				{

				}

				entries.add(entry);
				int v = done.incrementAndGet();
				if (v % 50000 == 0)
				{

					System.out.println(v + "/" + total);
				}
			});
			return entries;
		} catch (Exception ex)
		{
			ex.printStackTrace();
			return Collections.emptySet();
		}
	}
}
