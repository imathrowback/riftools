package org.imathrowback.telaradbdiff;

import java.io.*;
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
import org.imathrowback.datparser.DataModel;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.imathrowback.manifest.Versions;
import org.imathrowback.telaradb.TelaraDB;
import org.imathrowback.telaradb.TelaraDBUtil;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

import com.google.common.io.Files;
import com.sksamuel.diffpatch.DiffMatchPatch.Diff;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

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
			//if (autoDownloadLangDB && releaseTypeA == null && releaseTypeB == null)
			//	throw new CmdLineException(parser, "Release type must be specified in addition to auto download");

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
				System.out.println("Loading english language DB(b) " + langB);
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
		DataModel dataModel = new DataModel(dbResolve);
		PrintWriter newFos = new PrintWriter(
				new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("new.xml")), "UTF-8"));
		PrintWriter dbStringsA = new PrintWriter(
				new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("db_stringsA.txt")), "UTF-8"));
		PrintWriter dbStringsB = new PrintWriter(
				new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream("db_stringsB.txt")), "UTF-8"));
		try
		{
			int totalCount = idsB.size();
			AtomicInteger count = new AtomicInteger();
			AtomicInteger lastP = new AtomicInteger();
			//for (Pair<Integer, Integer> idB : idsB)
			idsB.parallelStream().forEach(idB -> {

				try
				{
					int id = idB.getLeft();
					int key = idB.getRight();
					if (!idsA.contains(idB))
					{
						//System.out.println("added in B:" + idB);
						byte[] data = fileB.getData(idB.getLeft(), idB.getRight());
						CObject obj = DatParser
								.processFileAndObject(
										new ByteArrayInputStream(data),
										dataModel);
						obj.index = id;
						obj.extracode = key;

						if (langAdb != null)
							transmog(obj, langBdb);

						XStream str = new XStream();
						if (json)
							str = new XStream(new JsonHierarchicalStreamDriver());
						str.processAnnotations(CObject.class);
						Path dbDir = Paths.get(outdir.toString(), "db", "new");
						dbDir.toFile().mkdir();
						Path aPath = Paths.get(dbDir.toString(), id + "_" + key + ".dat");
						Files.write(data, aPath.toFile());
						synchronized (newFos)
						{
							str.toXML(obj, newFos);
							newFos.println("");
							newFos.println("---");
						}
						writeStrings(dbStringsB, obj);
					} else
					{
						// check for changed
						byte[] dataA = fileA.getCompressedData(id, key);
						byte[] dataB = fileB.getCompressedData(id, key);
						if (!Arrays.equals(dataA, dataB))
						{
							XStream str = new XStream();
							if (json)
								str = new XStream(new JsonHierarchicalStreamDriver());
							str.processAnnotations(CObject.class);

							//System.out.println("changed:" + idB);
							CObject objA = DatParser
									.processFileAndObject(
											new ByteArrayInputStream(fileA.getData(idB.getLeft(), idB.getRight())),
											dataModel);
							CObject objB = DatParser
									.processFileAndObject(
											new ByteArrayInputStream(fileB.getData(idB.getLeft(), idB.getRight())),
											dataModel);

							if (langAdb != null)
								transmog(objA, langAdb);
							if (langBdb != null)
								transmog(objB, langBdb);

							String a = str.toXML(objA);
							String b = str.toXML(objB);
							if (!a.equals(b))
							{
								writeStrings(dbStringsA, objA);
								writeStrings(dbStringsB, objB);

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
							}
						}
					}
				} catch (Exception ex)
				{
					System.err.println("Error processing entry:" + idB);
					ex.printStackTrace();
				} finally
				{
					synchronized (dataModel)
					{
						int c = count.incrementAndGet();
						int per = (int) (((float) c / (float) totalCount) * 100.0f);
						if (lastP.get() != per)
						{
							if ((per % 5) == 0)
								System.out.print(per + "%");
							else
								System.out.print(".");
							lastP.set(per);
						}
					}
				}
			});
		} finally
		{
			newFos.close();
			dbStringsA.close();
			dbStringsB.close();

			ProcessBuilder diff = new ProcessBuilder("diff", "-d", "db_stringsA.txt", "db_stringsB.txt");
			diff = diff.redirectOutput(new File("db_strings_diff.txt"));
			Process p = diff.start();
			p.waitFor();

		}
		System.out.println(
				"Done. See new.xml for any additions and " + Paths.get(outdir.toString(), "db") + " for changes.");

	}

	private void writeStrings(final PrintWriter writer, final CObject obj)
	{
		if (obj.type == 6)
			writer.println(obj.convert() + "");
		for (CObject o : obj.members)
			writeStrings(writer, o);
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
