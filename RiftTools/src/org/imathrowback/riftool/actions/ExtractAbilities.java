package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import org.imathrowback.datparser.CObject;
import org.imathrowback.telaradb.TelaraDB;
import org.kohsuke.args4j.Option;

import rift_extractor.EnglishLang;
import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;
import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.classes.TextEntry;
import rift_extractor.classgen.classes._6008;
import rift_extractor.classgen.classes._81;

public class ExtractAbilities extends RiftAction
{
	@Option(name = "-riftDir", usage = "Directory where RIFT is installed", required = true)
	File riftDir;
	@Option(name = "-overwrite", usage = "True to overwrite existing files, defaults to false", required = false)
	boolean overwrite = false;

	@Option(name = "-outputDir", usage = "Write any output to this directory", required = true)
	File outputDir;
	@Option(name = "-32")
	boolean is32 = false;
	TelaraDB db;
	EnglishLang lang;
	AssetDatabase adb;

	@Override
	public void go()
	{
		try
		{
			if (riftDir != null && riftDir.exists() && riftDir.isDirectory())
			{
				String manifestStr = "assets.manifest";
				if (!is32)
				{
					manifestStr = "assets64.manifest";
					System.out.println("==> Using 64bit manifest, if you have 32bit RIFT installed, use the -32 flag");
				} else
					System.out.println("==> Using 32bit manifest");

				outputDir.mkdirs();

				File assetsManifest = Paths.get(riftDir.toString(), manifestStr).toFile();

				File assetsDirectory = Paths.get(riftDir.toString(), "assets").toFile();
				Manifest manifest = new Manifest(assetsManifest.toString());
				adb = AssetProcessor.buildDatabase(manifest, assetsDirectory.toString());

				db = new TelaraDB(adb);
				lang = new EnglishLang(adb.extractUsingFilename("lang_english.cds"));
				try (final PrintWriter pw = new PrintWriter(
						Paths.get(outputDir.getAbsolutePath(), "ability_index.txt").toFile()))
				{
					db.getKeys(83).parallel().map(x -> get(db, 83, x))
							.forEach(x -> {
								try
								{
									_81 ee = ClassUtils.newClass(_81.class, x);
									write(ee);
									pw.println(x.key + "," + getText(lang, ee.unk27) + "," + getIconName(ee));
								} catch (Exception ex)
								{

								}
							});

				}
				System.out.println("COMPLETE>>");

			} else
				throw new IllegalArgumentException("RIFT directory not valid:" + riftDir);
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	private String getIconName(final _81 ability) throws Exception
	{
		Long iconID = ability.unk39;
		if (iconID != null && iconID > 0)
		{
			_6008 icon = (_6008) get(db, 6009, iconID);
			if (icon != null && icon.unk1 != null)
			{
				String iconFileName = icon.unk1;
				String assetName = new File(iconFileName + ".dds").getName();
				return assetName;
			}
		}
		return null;

	}

	private String write(final _81 ability)
	{
		try
		{
			String name = getText(lang, ability.unk27);
			String text = getText(lang, ability.unk28);

			///System.out.println(name + ">>>" + text);
			Long iconID = ability.unk39;
			if (iconID != null && iconID > 0)
			{
				_6008 icon = (_6008) get(db, 6009, iconID);
				if (icon != null && icon.unk1 != null)
				{
					String iconFileName = icon.unk1;
					String assetName = new File(iconFileName + ".dds").getName();
					String outputName = Paths.get(outputDir.getAbsolutePath(), assetName).toString();
					if (!new File(outputName).exists() || overwrite)
						adb.extractToFilename(assetName, outputName);
					return (name + "," + assetName);
				}
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return "";

	}

	public static void main(final String[] args) throws Exception
	{
		ExtractAbilities ea = new ExtractAbilities();
		ea.riftDir = new File("L:\\SteamStuff\\Steam2\\steamapps\\common\\rift\\");
		ea.go();
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

	private static <T> T get(final TelaraDB db, final int id, final Long key) throws Exception
	{
		CObject obj = db.getObject(id, key.intValue());
		return ClassUtils.newClass(obj);
	}

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

	private static String format(final String s)
	{
		return s.replace("\"", "`");
	}
}
