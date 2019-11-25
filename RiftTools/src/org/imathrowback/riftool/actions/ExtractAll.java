package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.InvalidPathException;
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
	@Option(name = "-outputDir", usage = "The directory to extract to (required)", metaVar = "DIR", required = true)
	File outputDir;

	@Option(name = "-riftDir", usage = "The RIFT directory (required)", metaVar = "DIR", required = true)
	File riftDir;
	@Option(name = "-64")
	boolean is64 = true;
	@Option(name = "-dryRun", usage = "Simulate an extraction but don't write any files")
	boolean dryRun = false;

	@Option(name = "-onlyFile", usage = "Only extract the asset for the given filename", metaVar = "filename")
	String onlyFile;

	public ExtractAll()
	{

	}

	@Override
	public void go() throws IOException
	{
		if (dryRun)
			System.out.println("NOTICE: Dry run mode, no files will be written");
		DefaultDetector dd = new DefaultDetector(null);
		String manifestStr = "assets.manifest";
		if (is64)
			manifestStr = "assets64.manifest";
		File assetsManifest = Paths.get(riftDir.toString(), manifestStr).toFile();
		File assetsDirectory = Paths.get(riftDir.toString(), "assets").toFile();
		Manifest manifest = new Manifest(assetsManifest.toString());
		AssetDatabase adb = AssetProcessor.buildDatabase(manifest, assetsDirectory.toString());

		if (onlyFile != null && onlyFile.length() > 0)
		{
			AssetEntry entry = adb.getEntryForFileName(onlyFile);
			if (entry != null)
			{
				File outFile = Paths.get(outputDir.toString(), onlyFile).toFile();
				System.out.println("writing " + outFile);
				if (!dryRun)
					adb.extractToFilename(onlyFile, outFile.toString());
			}
			return;
		}
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

			try
			{
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
				// strip out any paths

				if (filename == null)
				{
					noName = true;
					filename = choice.filenameHashStr;
				}

				String base = FilenameUtils.getName(filename);
				if (!base.equals(filename))
				{
					//System.out.println("\nWarning, stripping path from filename:" + filename
					//		+ ", this filename is most likely WRONG");
					filename = choice.filenameHashStr;
					noName = true;
				}

				try
				{
					Paths.get(filename);
				} catch (InvalidPathException ex)
				{
					//System.out.println("\nWarning, bad filename:" + filename
					//		+ ", this filename is most likely WRONG");
					filename = choice.filenameHashStr;
					noName = true;
				}

				if (!outDir.toFile().exists() && !dryRun)
					outDir.toFile().mkdir();
				Path outFile;
				if (noName)
				{
					byte[] data = adb.extract(ae);
					String ext = dd.detectExtension(data);
					outFile = Paths.get(outDir.toString(), filename);
					if (ext != null)
						outFile = Paths.get(outDir.toString(), filename + "." + ext);
					if (!dryRun)
					{
						if (!outFile.toFile().exists())
							try (FileOutputStream fos = new FileOutputStream(outFile.toFile()))
							{
								fos.write(data);
							}
					}
				} else
				{
					outFile = Paths.get(outDir.toString(), filename);
					if (!dryRun)
					{
						if (!outFile.toFile().exists())
							try (FileOutputStream fos = new FileOutputStream(outFile.toFile()))
							{
								adb.extract(ae, fos);
							}
					}
				}
			} catch (Exception ex)
			{
				System.out.println("error handing asset:" + ae);
				ex.printStackTrace();
			}
			//System.out.println("write:" + outFile + "");

		}
		System.out.println("done...");
		System.out.println(
				"NOTE: Due to the FNVHash used by RIFT there is a high possibility that name collisions will cause some filenames to be incorrect.");
	}
}
