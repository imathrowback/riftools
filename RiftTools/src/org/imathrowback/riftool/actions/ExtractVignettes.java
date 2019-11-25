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

		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
