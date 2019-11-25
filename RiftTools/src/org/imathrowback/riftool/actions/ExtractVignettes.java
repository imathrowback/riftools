package org.imathrowback.riftool.actions;

import java.io.File;
import java.nio.file.Paths;
import org.kohsuke.args4j.Option;

import rift_extractor.Binky;
import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;

public class ExtractVignettes extends RiftAction
{
	@Option(name = "-convert", usage = "Automatically convert the OGG files to something usuable")
	boolean autoConvert = false;
	@Option(name = "-64")
	boolean is64 = true;
	@Option(name = "-riftDir", usage = "The RIFT directory (required)", metaVar = "DIR", required = true)
	File riftDir;
	@Option(name = "-outputDir", usage = "The directory to extract to (required)", metaVar = "DIR", required = true)
	File outputDir;

	public ExtractVignettes()
	{

	}

	@Override
	public void go()
	{
		try
		{
			String manifestStr = "assets.manifest";
			if (is64)
				manifestStr = "assets64.manifest";
			File assetsManifest = Paths.get(riftDir.toString(), manifestStr).toFile();

			File assetsDirectory = Paths.get(riftDir.toString(), "assets").toFile();
			Manifest manifest = new Manifest(assetsManifest.toString());
			AssetDatabase adb = AssetProcessor.buildDatabase(manifest, assetsDirectory.toString());

			Binky.doVig(manifest, adb, outputDir);
			if (autoConvert)
			{
				System.out.println("Doing autoconvert of OGG files to WAV (this may take a while)");
				File[] files = outputDir.listFiles();
				int totalCount = files.length;
				int index = 0;
				int lastP = -1;
				for (File file : files)
				{
					int per = (int) (((float) ++index / (float) totalCount) * 100.0f);
					if (lastP != per)
					{
						if ((per % 25) == 0)
							System.out.print(per + "%");
						else if ((per % 5) == 0)
							System.out.print(".");
						lastP = per;
					}
					if (file.isFile() && file.getName().endsWith("ogg"))
					{
						// autoconvert
						Process process = Runtime.getRuntime()
								.exec(new String[] { "vgmstream\\test.exe", file.toString() });
						int p = process.waitFor();
						if (p == 0)
						{
							//System.out.println("Conversion Success!");
							file.delete();
						} else
						{
							System.out.println("Conversion failure: " + file);

						}
					}
				}
			}

		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
