package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.imathrowback.manifest.NameDB;
import org.kohsuke.args4j.Option;

import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetEntry;
import rift_extractor.assets.AssetProcessor;
import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;
import rift_extractor.detector.DefaultDetector;

public class ExtractAll extends RiftAction
{
	@Option(name = "-outputDir", usage = "The directory to extract to", metaVar = "DIR")
	File outputDir;

	@Option(name = "-riftDir", usage = "The RIFT directory", metaVar = "DIR")
	File riftDir;

	public ExtractAll()
	{

	}

	@Override
	public void go() throws IOException
	{
		DefaultDetector dd = new DefaultDetector(null);
		File assetsManifest = Paths.get(riftDir.toString(), "assets64.manifest").toFile();
		File assetsDirectory = Paths.get(riftDir.toString(), "assets").toFile();
		Manifest manifest = new Manifest(assetsManifest.toString());
		AssetDatabase adb = AssetProcessor.buildDatabase(manifest, assetsDirectory.toString());

		List<AssetEntry> entries = adb.getEntries().collect(Collectors.toList());
		int lastP = -1;
		int aeCount = 0;
		int totalSize = entries.size();
		for (AssetEntry ae : entries)
		{
			int per = (int) (((float) (aeCount++) / (float) totalSize) * 100.0f);
			if (lastP != per)
			{
				if ((per % 25) == 0)
					System.out.print(per + "%");
				else if ((per % 5) == 0)
					System.out.print(".");
				lastP = per;
			}

			if (ae.file.file.getName().contains("assets32"))
				continue;

			Stream<ManifestEntry> manifestEntriesStream = manifest.getEntries(ae.strID);

			Optional<ManifestEntry> mchoice = manifestEntriesStream.filter(e -> e.lang <= 1)
					.findFirst();
			if (!mchoice.isPresent())
			{
				List<ManifestEntry> amentries = manifest.getEntries(ae.strID).collect(Collectors.toList());
				if (amentries.isEmpty())
					System.err.println("No manifest entry for asset:" + ae);
				mchoice = Optional.of(amentries.get(0));
			}

			ManifestEntry choice = mchoice.get();

			String pakFile = FilenameUtils.getBaseName(manifest.getPAKName(choice.getPakIndex()));
			Path outDir = Paths.get(outputDir.toString(), pakFile);
			boolean noName = false;
			String filename = NameDB.getNameForHash(choice.filenameHashStr, null);
			if (filename == null)
			{
				noName = true;
				filename = choice.filenameHashStr;
			}

			if (true)
				continue;

			if (!outDir.toFile().exists())
				outDir.toFile().mkdir();
			Path outFile;
			if (noName)
			{
				byte[] data = adb.extract(ae);
				String ext = dd.detectExtension(data);
				outFile = Paths.get(outDir.toString(), filename);
				if (ext != null)
					outFile = Paths.get(outDir.toString(), filename + "." + ext);
				try (FileOutputStream fos = new FileOutputStream(outFile.toFile()))
				{
					fos.write(data);
				}
			} else
			{
				outFile = Paths.get(outDir.toString(), filename);
				try (FileOutputStream fos = new FileOutputStream(outFile.toFile()))
				{
					adb.extract(ae, fos);
				}
			}

			//System.out.println("write:" + outFile + "");

		}
		System.out.println("done...");
	}
}
