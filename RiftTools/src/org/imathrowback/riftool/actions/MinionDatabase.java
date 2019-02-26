package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.imathrowback.datparser.CObject;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.imathrowback.telaradb.TelaraDB;
import org.kohsuke.args4j.Option;

import rift_extractor.EnglishLang;
import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.classes.*;

public class MinionDatabase extends RiftAction
{
	@Option(name = "-lang", usage = "language", required = false)
	int lang = -1;

	File aa;
	File bb;

	@Override
	public void go()
	{
		try
		{
			aa = File.createTempFile("aaminiondb", "db");
			aa.deleteOnExit();
			bb = File.createTempFile("bbminiondb", "cds");
			bb.deleteOnExit();

			RemotePAK.downloadLatest(ReleaseType.PTS, "telara.db", aa.toString(), -1);
			RemotePAK.downloadLatest(ReleaseType.PTS, "lang_english.cds", bb.toString(), -1);
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
		PrintWriter pw = new PrintWriter("Minions.csv");

		TelaraDB db = new TelaraDB(aa);
		EnglishLang lang = new EnglishLang(Files.readAllBytes(bb.toPath()));
		TreeMap<Integer, _10890> statNames = getStats(db);

		List<_10851> minions = db.getKeys(10850).sorted().map(x -> get(db, 10850, x))
				.map(x -> ClassUtils.newClass(_10851.class, x)).sorted((a, b) -> {
					return comp(lang, a.unk2, b.unk2);
				})
				.collect(Collectors.toList());

		pw.print("Minion,");
		for (int i : statNames.keySet())
			for (int l = 1; l <= 25; l++)
				pw.print(statNames.get(i).unk0 + ":" + l + ",");
		for (int l = 1; l <= 25; l++)
			pw.print("Stam:" + l + ",");
		pw.print("Attractor");
		pw.print(",Details");
		pw.println("");

		for (_10851 minion : minions)
		{
			TextEntry te = minion.unk2;
			if (te != null && te.unk0 != null)
			{
				String tex = lang.getText(te.unk0);
				pw.print("\"" + tex + "\"");
				pw.print(",");
				_10853 archetype = get(db, 10852, minion.unk6);
				// for each stat, print it at max level
				for (int i : statNames.keySet())
				{
					for (int l = 1; l <= 25; l++)
					{
						pw.print(getStat(db, i, archetype, l));
						pw.print(",");
					}
				}

				try
				{
					_10870 stam = get(db, 10869, minion.unk8);
					HashMap<Long, _303> stamMap = stam.unk1;
					for (long l = 1; l <= 25; l++)
					{

						if (stamMap.containsKey(l))
						{
							_303 stamgen = stamMap.get(l);
							pw.print(stamgen.unk0);
						}
						pw.print(",");
					}

				} catch (Exception ex)
				{
					System.err.println("Err getting 10869:" + minion.unk8);
				}
				pw.print(",");
				if (minion.unk14 != null && minion.unk14.size() > 0)
					pw.print(minion.unk14.size() + ",");
				else
					pw.print(",");
				pw.print("\"" + getText(lang, minion.unk12) + "\"");
				pw.println("");
			} else
				System.err.println("err no text minion");
			pw.flush();
		}

		pw.close();
	}

	private static String format(final String s)
	{
		return s.replace("\"", "`");
	}

	private static String getText(final EnglishLang lang, final TextEntry unk2)
	{
		return format(unk2 == null || unk2.unk0 == null ? "" : lang.getText(unk2.unk0));
	}

	private static int comp(final EnglishLang lang, final TextEntry unk2, final TextEntry unk22)
	{
		String a = getText(lang, unk2);
		String b = getText(lang, unk22);

		return a.compareTo(b);
	}

	private static String getStat(final TelaraDB db, final Integer statIndex, final _10853 archetype, final long l)
			throws Exception
	{
		HashMap<Long, _10871> stats = archetype.unk1;
		if (stats.containsKey(statIndex.longValue()))
		{
			_10871 statEntry = stats.get(statIndex.longValue());
			_10870 statGrowth = get(db, 10869, statEntry.unk0);

			HashMap<Long, _303> statgrowthmap = statGrowth.unk1;
			_303 gen = statgrowthmap.get(l);
			if (gen == null)
			{
				//System.err.println("Failed to get level 25 from stat:" + statGrowth.unk0);
				return "";
			}
			return "" + gen.unk0;

		}
		return "";

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

	private static TreeMap<Integer, _10890> getStats(final TelaraDB db)
	{
		TreeMap<Integer, _10890> stats = new TreeMap<>();
		db.getKeys(10856).sorted().forEach(key -> {
			try
			{
				CObject obj = db.getObject(10856, key);
				stats.put(key, ClassUtils.newClass(obj));
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		return stats;
	}

}
