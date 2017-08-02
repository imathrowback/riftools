package org.imathrowback.mapgen;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.imathrowback.datparser.DatParser;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.classes._105;
import rift_extractor.util.Util;

public class MapGen
{
	@Option(name = "-riftDirectory", usage = "RIFT directory", required = true)
	File riftDir;
	@Option(name = "-world", usage = "World name, can also be instance name, eg world/world2/world3/world4", required = true)
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
			System.err.println("java ManifestDiff [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// print option sample. This is useful some time
			System.err.println("  Example: java ManifestDiff" + parser.printExample(OptionHandlerFilter.ALL));
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

		_105 worldDef = ClassUtils.newClass(DatParser
				.processFileAndObject(new ByteArrayInputStream(adb.extractUsingFilename(worldName + "_map.cdr"))));

		int widthY = worldDef.unk3.intValue() * 256;
		int widthX = widthY;
		if (worldDef.unk2 != null)
			widthX = worldDef.unk2.intValue() * 256;

		String dir = outputDir.toString();
		outputDir.mkdir();
		System.out.println("Extracting files..");
		String filesTxt = worldName + "_files.txt";
		try (PrintWriter cmd = new PrintWriter(Paths.get(dir, "maketiff.bat").toFile()))
		{
			cmd.println("@echo off");
			cmd.println(
					"..\\montage @" + filesTxt + " -geometry +0+0 -tile " + widthX / 256 + "x" + widthY / 256
							+ " " + worldName + ".tiff");
			try (PrintWriter writer = new PrintWriter(Paths.get(dir, filesTxt).toFile()))
			{
				for (int y = 0; y < widthY; y += 256)
					for (int x = 0; x < widthX; x += 256)
					{
						//for (int i = 0; i < 6000; i++)
						{
							String name = worldName + "_terrain_" + x + "_" + y + "_mapimage.dds";
							String nameHash = Util.hashFileName(name);
							List<ManifestEntry> entries = manifest.fileNameHashesIDMap.get(nameHash);
							if (entries != null)
							{
								for (ManifestEntry e : entries)
								{
									String s = manifest.getPAKName(e.pakIndex);
									if (s.contains("texture_map"))
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
		}
		if (build)
		{
			//montage @files.txt -geometry +0+0 -tile " + widthX / 256 + "x" + widthY / 256 + " all.tiff");
			File montageExe = new File("montage.exe");
			ProcessBuilder pb = new ProcessBuilder(montageExe.toString(),
					"@" + Paths.get(outputDir.toString(), filesTxt).toString(), "-geometry", "+0+0",
					"-tile", widthX / 256 + "x" + widthY / 256,
					Paths.get(outputDir.toString(), worldName + ".tiff").toString()).inheritIO();

			System.out.println("Executing montage process:" + pb.command());

			pb.start().waitFor();
			System.out.println("Complete. See the TIFF file in the " + outputDir + " directory.");
		} else
			System.out.println("Complete. Run maketiff.bat to finish building.");
	}
}
