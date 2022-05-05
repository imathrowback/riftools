package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.imathrowback.datparser.CObject;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.imathrowback.telaradb.TelaraDB;
import org.kohsuke.args4j.Option;

import rift_extractor.EnglishLang;
import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.classes.TextEntry;
import rift_extractor.classgen.classes._893;
import rift_extractor.classgen.classes._898;

public class ExtractWorldQuests extends RiftAction
{
	int lang = -1;
	@Option(name = "-db", usage = "Optional filename of the database, if set, -lang must also be set", required = false)
	File db;
	@Option(name = "-langdb", usage = "Optional filename of the language database, if set, must also use -db", required = false)
	File langdb;

	@Option(name = "-output", usage = "Write the output to this file, if not set, will be written to worldquests.csv", required = false)
	File output;

	@Option(name = "-release", usage = "Release to download from", required = true)

	ReleaseType releaseType;
	@Option(name = "-64")
	boolean is64 = true;

	File telaraDBTemp;
	File langDBTemp;

	public ExtractWorldQuests()
	{

	}

	@Override
	public void go()
	{
		try
		{

			if (db == null || !db.exists())
			{
				if (releaseType == null)
					throw new IllegalArgumentException("Release type cannot be empty and no db set");
				System.out.println("Using release:" + releaseType);
				output = new File("worldquests_" + releaseType.name() + ".csv");

				telaraDBTemp = File.createTempFile("aawqb", "db");
				telaraDBTemp.deleteOnExit();
				langDBTemp = File.createTempFile("bbwqdb", "cds");
				langDBTemp.deleteOnExit();

				System.out.println("Download database..");
				RemotePAK.downloadLatest(releaseType, "telara.db", telaraDBTemp.toString(), lang, is64);
				System.out.println("Download language file...");
				RemotePAK.downloadLatest(releaseType, "lang_english.cds", langDBTemp.toString(), lang, is64);
			} else
			{
				if (output == null)
					output = new File("worldquests.csv");

				telaraDBTemp = (db);
				langDBTemp = (langdb);
			}
			goA();
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		} finally
		{
		}
	}

	void goA() throws Exception
	{
		try (PrintWriter pw = new PrintWriter(output))
		{

			TelaraDB db = new TelaraDB(telaraDBTemp);
			EnglishLang lang = new EnglishLang(Files.readAllBytes(langDBTemp.toPath()));
			System.out.println("parse quests...");

			List<_893> quests = db.getKeys(894).sorted().map(x -> get(db, 894, x))
					.map(x -> ClassUtils.newClass(_893.class, x)).collect(Collectors.toList());
			System.out.println("write world quest details...");

			pw.println("name|tempory text|description|start|end");
			for (_893 quest : quests)
			{
				String name = getText(lang, quest.unk0);
				String tempText = getTempText(lang, quest.unk0);
				String description = getText(lang, quest.unk2);
				Date end = quest.getEndTime();

				if (quest.unk1 != null)
				{
					for (_898 entry : quest.unk1)
					{
						if (entry != null)
						{
							Date start = entry.getStartTime();
							pw.println(name + "|" + tempText + "|" + description + "|" + start + "|" + end);
						} else
							pw.println(name + "|" + tempText + "|" + description + "|" + "" + "|" + end);
					}
				} else
					pw.println(name + "|" + tempText + "|" + description + "|" + "" + "|" + end);

			}
			pw.close();
		} finally
		{
		}

		System.out.println("World Quests written to " + output);
	}

	private static String format(final String s)
	{
		return s.replace("\"", "`");
	}

	private static String getText(final EnglishLang lang, final TextEntry unk2)
	{
		return format(unk2 == null || unk2.unk0 == null ? "" : lang.getText(unk2.unk0));
	}

	private static String getTempText(final EnglishLang lang, final TextEntry unk2)
	{
		return format(unk2.tempText == null ? "" : unk2.tempText);
	}

	private static <T> T get(final TelaraDB db, final int id, final Long key) throws Exception
	{
		CObject obj = db.getObject(id, key.intValue());
		return ClassUtils.newClass(obj);
	}

	/*
	private static _10870 getStatGrowth(final TelaraDB db, final int key) throws Exception
	{
		return ClassUtils.newClass(db.getObject(10869, key));
	}
	*/

	private static CObject get(final TelaraDB db, final int i, final Integer x)
	{
		try
		{
			return db.getObject(i, x);
		} catch (Exception e)
		{
			throw new IllegalStateException(e);
		}
	}
}
