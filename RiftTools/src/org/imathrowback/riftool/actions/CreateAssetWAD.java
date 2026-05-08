package org.imathrowback.riftool.actions;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Option;

import rift_extractor.assets.Manifest;
import rift_extractor.assets.WADWriter;

public class CreateAssetWAD extends RiftAction
{
	@Option(name = "-riftDir", usage = "RIFT install directory", required = true)
	File riftDir;

	@Option(name = "-assetName", usage = "Name of the asset in the manifest to replace", required = true)
	String assetName;

	@Option(name = "-inputFile", usage = "Path to the replacement file", required = true)
	File inputFile;

	@Option(name = "-wadIndex", usage = "WAD file index (e.g. 999 writes to assets.999)")
	int wadIndex = 999;

	@Option(name = "-32")
	boolean is32 = false;

	@Override
	public void go()
	{
		try
		{
			String manifestName = is32 ? "assets.manifest" : "assets64.manifest";
			File manifestFile = Paths.get(riftDir.toString(), manifestName).toFile();
			if (!manifestFile.exists())
				throw new IllegalArgumentException("Manifest not found: " + manifestFile);

			Manifest manifest = new Manifest(manifestFile.toString());

			String wadFilename = "assets." + wadIndex;
			File wadFile = Paths.get(riftDir.toString(), "assets", wadFilename).toFile();
			wadFile.getParentFile().mkdirs();

			List<WADWriter.AssetOutEntry> entries = new ArrayList<>();
			entries.add(WADWriter.fromFile(manifest, assetName, inputFile.toString()));

			String manifestPath = manifestFile.getAbsolutePath();
			WADWriter.writeWAD(wadFile.toString(), entries, manifest, manifestPath);

			System.out.println("WAD written to " + wadFile);
			System.out.println("Manifest updated: " + manifestPath);
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
