package org.imathrowback.mapgen;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import org.apache.commons.io.FilenameUtils;
import org.imathrowback.datparser.CObject;
import org.imathrowback.datparser.DatParser;
import org.imathrowback.telaradb.TelaraDB;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

import rift_extractor.EnglishLang;
import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.classes.*;
import rift_extractor.util.Util;

public class MapGen
{
	@Option(name = "-writeMapInfo", usage = "Write map data such as zone info and spawn locations", required = false)
	boolean writeMapInfo = false;

	@Option(name = "-stylized", usage = "Stylized map with borders and roads", required = false)
	boolean stylized = false;

	@Option(name = "-listWorlds", usage = "Write list of worlds and exit", required = false)
	boolean listWorlds = false;

	@Option(name = "-riftDirectory", usage = "RIFT directory", required = true)
	File riftDir;
	@Option(name = "-world", usage = "World name, can also be instance name, eg world/world2/world3/world4", required = false)
	String worldName;

	@Option(name = "-outdir", usage = "Output directory for files and final image", required = true)
	File outputDir = new File("");

	@Option(name = "-build", usage = "If true will auto start a build of the map", required = false)
	boolean build = false;

	public static void main(final String[] args)
	{
		try
		{
			new MapGen().doMain(Arrays.asList(args));
		} catch (Exception eX)
		{
			System.err.println("An unhandled exception occurred:" + eX.getMessage());
			eX.printStackTrace();
		}
	}

	public void doMain(final Collection<String> args) throws Exception
	{
		//Systme.out.println(Arrays.toString(a))
		CmdLineParser parser = new CmdLineParser(this);
		parser.setUsageWidth(80);
		try
		{
			parser.parseArgument(args);

		} catch (CmdLineException e)
		{
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			System.err.println("java MapGen [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// print option sample. This is useful some time
			System.err.println("  Example: java MapGen" + parser.printExample(OptionHandlerFilter.ALL));
			return;
		}

		String assetsManifest64 = Paths.get(riftDir.toString(), "assets64.manifest").toString();
		String assetsManifest32 = Paths.get(riftDir.toString(), "assets.manifest").toString();
		String assetsDirectory = Paths.get(riftDir.toString(), "assets").toString();

		String assetsManifest = assetsManifest64;
		if (!new File(assetsManifest).exists())
			assetsManifest = assetsManifest32;

		if (!new File(assetsManifest).exists())
			throw new IllegalArgumentException(
					"Unable to find assets64.manifest or assets.manifest in rift directory: " + riftDir);

		Manifest manifest = new Manifest(assetsManifest);
		AssetDatabase adb = AssetProcessor.buildDatabase(manifest, assetsDirectory);
		TelaraDB tb = new TelaraDB(adb);

		if (listWorlds)
		{
			try (PrintWriter fw = new PrintWriter(Paths.get(outputDir.toString(), "worlds.txt").toFile()))
			{
				TreeSet<String> worlds = new TreeSet<>();
				tb.getKeys(4479).forEach(k -> {
					try
					{
						CObject obj = tb.getObject(4479, k);
						String worldName = obj.getString(0);
						worlds.add(worldName);

					} catch (Exception e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});
				worlds.forEach(s -> {
					System.out.println(s);
					fw.println(s);
				});
			}
			return;
		}
		if (worldName == null || worldName.length() <= 0)
			throw new IllegalArgumentException("World name not specified");

		_105 worldDef = ClassUtils.newClass(DatParser
				.processFileAndObject(new ByteArrayInputStream(adb.extractUsingFilename(worldName + "_map.cdr"))));

		String dir = outputDir.toString();
		outputDir.mkdir();
		System.out.println("Extracting files..");
		String filesTxt = worldName + "_files.txt";

		int strideX = 256;
		int strideY = 256;
		int widthY = worldDef.height.intValue();
		int widthX = widthY;
		if (worldDef.width != null)
			widthX = worldDef.width.intValue();
		System.out.println("size " + widthX + "x" + widthY + ", stride " + strideX + "x" + strideY);
		BiFunction<Integer, Integer, String> mapName;
		if (writeMapInfo)
		{
			TelaraDB tDB = new TelaraDB(adb);

			EnglishLang lang = new EnglishLang(adb.extractUsingFilename("lang_english.cds"));

			MapInfo info = new MapInfo();
			info.height = widthY;
			info.width = widthX;
			// write zones
			List<_109> zones = worldDef.mapZones;
			for (_109 zone : zones)
			{
				Zone z = new Zone();
				for (_305 v : zone.points)
					z.points.add(new Float[] { v.x, v.y, v.z });
				z.id = zone.refTo113;
				CObject mapZone = tDB.getObject(113, z.id.intValue());
				if (mapZone != null)
				{
					TextEntry id = ClassUtils.getFieldMember(TextEntry.class, mapZone, 0);

					z.name = lang.getText(id.unk0);

					z.excludeFromMap = mapZone.getBoolean(13, false);
					z.minLevel = mapZone.getInt(27, -1);
					z.maxLevel = mapZone.getInt(28, -1);
				}
				info.zones.add(z);
			}

			// write scenes
			List<_110> scenes = worldDef.mapScenes;
			for (_110 scene : scenes)
			{
				Scene s = new Scene();
				for (_305 v : scene.unk3)
					s.points.add(new Float[] { v.x, v.y, v.z });
				s.sceneID = scene.refTo114;
				//CObject mapScene = tDB.getObject(115, s.areaID.intValue());
				_116 mapScene = ClassUtils.newClass(_116.class, tDB.getObject(114, s.sceneID.intValue()));

				if (mapScene != null)
				{
					if (mapScene.unk0 != null && mapScene.unk0.unk0 != null)
						s.name = lang.getText(mapScene.unk0.unk0);
					else
						s.name = mapScene.unk1;
					if (mapScene.unk14 != null)
						s.suppressLabel = mapScene.unk14;
					info.scenes.add(s);
				}
			}
			// write spawns
			List<Integer> spawnKeys = tDB.getKeys(4479).collect(Collectors.toList());
			for (Integer spawnKey : spawnKeys)
			{
				try
				{
					_4478 spawn = ClassUtils.newClass(_4478.class, tDB.getObject(4479, spawnKey));
					String map = spawn.unk0;
					if (map.equals(worldName))
					{
						Teleport tele = new Teleport();
						if (spawn.unk5 != null)
							tele.image = spawn.unk5;
						tele.internalName = spawn.unk1;
						if (spawn.unk10 != null && spawn.unk10.unk0 != null)
							tele.name = lang.getText(spawn.unk10.unk0);
						if (spawn.unk2 != null)
							tele.pos = new Float[] { spawn.unk2.v1, spawn.unk2.v2, spawn.unk2.v3 };
						if (spawn.unk3 != null)
							tele.angle = spawn.unk3;
						if (tele.image != null && !tele.image.isEmpty())
						{
							String filename = FilenameUtils.getName(tele.image);
							if (adb.filenameExists(filename))
							{
								tele.imageFilename = filename;
								File outputFile = Paths.get(dir, filename).toFile();
								adb.extractToFilename(filename, outputFile.toString());
							} else
								System.err.println("WARN: Unable to find teleport thumbnail:" + filename);
						}
						info.teleports.add(tele);
					}
				} catch (ClassCastException ex)
				{
					System.err.println("Unable to process 4479:" + spawnKey);
				}

			}

			File file = Paths.get(dir, worldName + ".data.json").toFile();
			System.out.println("writing map data to " + file);
			try (FileWriter mapData = new FileWriter(file))
			{
				XStream xstr = new XStream(new JsonHierarchicalStreamDriver());
				xstr.toXML(info, mapData);
			}

		}
		if (stylized)
		{
			strideX = 1;
			strideY = 1;
			widthY = (widthY * 256) / 2048;
			widthX = (widthX * 256) / 2048;
			mapName = (x, y) -> worldName + "_map_big_revealed_" + x + "_" + y + ".dds";
		} else
		{
			strideX = strideY = 256;
			widthY *= strideY;
			widthX *= strideX;
			mapName = (x, y) -> worldName + "_terrain_" + x + "_" + y
					+ "_mapimage.dds";
		}

		try (PrintWriter cmd = new PrintWriter(Paths.get(dir, "maketiff.bat").toFile()))
		{
			cmd.println("@echo off");
			cmd.println(
					"..\\montage @" + filesTxt + " -geometry +0+0 -tile " + widthX / strideX + "x" + widthY / strideY
							+ " " + worldName + ".tiff");
			try (PrintWriter writer = new PrintWriter(Paths.get(dir, filesTxt).toFile()))
			{
				for (int y = 0; y < widthY; y += strideY)
					for (int x = 0; x < widthX; x += strideX)
					{
						String name = mapName.apply(x, y);
						//System.out.println("trying:" + name);
						//worldName + "_terrain_" + x + "_" + y + "_mapimage.dds";
						String nameHash = Util.hashFileName(name);
						List<ManifestEntry> entries = manifest.fileNameHashesIDMap.get(nameHash);
						if (entries != null)
						{
							for (ManifestEntry e : entries)
							{
								String s = manifest.getPAKName(e.pakIndex);
								if (s.contains("texture"))
								{
									if (adb.filenameExists(name))
									{
										String outname = Paths.get(dir, name).toString();
										writer.println(outname);
										if (!new File(outname).exists())
											adb.extractToFilename(name, outname);
									}
								}
							}
						}
					}
			}
		}
		if (build)
		{
			File montageExe = new File("montage.exe");
			ProcessBuilder pb = new ProcessBuilder(montageExe.toString(),
					"@" + Paths.get(outputDir.toString(), filesTxt).toString(), "-geometry", "+0+0",
					"-tile", widthX / strideX + "x" + widthY / strideY,
					Paths.get(outputDir.toString(), worldName + ".tiff").toString()).inheritIO();

			System.out.println("Executing montage process:" + pb.command());

			pb.start().waitFor();
			System.out.println("Complete. See the TIFF file in the " + outputDir + " directory.");
		} else
			System.out.println("Complete. Run maketiff.bat to finish building.");
	}
}
