package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.TreeSet;

import org.imathrowback.datparser.CObject;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.telaradb.TelaraDB;
import org.kohsuke.args4j.Option;

import rift_extractor.EnglishLang;
import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;
import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.classes.TextEntry;
import rift_extractor.classgen.classes._81;

public class GetPets extends RiftAction
{
	@Option(name = "-riftDir", usage = "Directory of RIFT", required = true)
	File riftDir;

	@Option(name = "-output", usage = "Write the output to this file, if not set, will be written to pets.csv", required = false)
	File output;

	ReleaseType releaseType;
	@Option(name = "-32")
	boolean is32 = false;

	@Override
	public void go()
	{
		try (PrintWriter pw = new PrintWriter(output))
		{
			String manifestStr = "assets.manifest";
			if (!is32)
			{
				manifestStr = "assets64.manifest";
				System.out.println("==> Using 64bit manifest, if you have 32bit RIFT installed, use the -32 flag");
			} else
				System.out.println("==> Using 32bit manifest");

			File assetsManifest = Paths.get(riftDir.toString(), manifestStr).toFile();

			File assetsDirectory = Paths.get(riftDir.toString(), "assets").toFile();
			Manifest manifest = new Manifest(assetsManifest.toString());
			AssetDatabase adb = AssetProcessor.buildDatabase(manifest, assetsDirectory.toString());

			TreeSet<String> outputS = new TreeSet<>();
			TelaraDB db = new TelaraDB(adb);
			EnglishLang lang = new EnglishLang(adb.extractUsingFilename("lang_english.cds"));
			db.getKeys(83).parallel().map(x -> get(db, 83, x))
					.forEach(x -> {
						try
						{
							_81 ee = ClassUtils.newClass(_81.class, x);
							if (ee.unk1 != null && ee.unk1 == 5)
								if (ee.unk7 != null)
									for (Long abilityEffectId : ee.unk7)
									{
										CObject _82Obj = get(db, 84, abilityEffectId.intValue());
										if (_82Obj != null)
										{
											CObject obj = _82Obj.getAtIndex(1);
											if (obj != null)
												for (CObject obja : obj.members)
												{
													if (obja.type == 1697)
													{
														String name = getText(lang, ee.unk27);
														String text = getText(lang, ee.unk28);
														if (name.length() > 0 && text.length() > 0)
														{
															synchronized (outputS)
															{
																outputS.add(name + ":" + text);
															}

														}
													}
												}
										}
									}

							//write(ee);
							//pw.println(x.key + "," + getText(lang, ee.unk27) + "," + getIconName(ee));
						} catch (Exception ex)
						{
							//ex.printStackTrace();
						}
					});
			for (String s : outputS)
				pw.println(s);

		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}

	private static String getText(final EnglishLang lang, final TextEntry unk2)
	{
		return format(unk2 == null || unk2.unk0 == null ? "" : lang.getText(unk2.unk0));
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
