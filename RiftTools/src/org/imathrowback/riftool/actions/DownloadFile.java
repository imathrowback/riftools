package org.imathrowback.riftool.actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.imathrowback.manifest.PatchInfo;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.kohsuke.args4j.Option;

import rift_extractor.assets.Manifest;
import rift_extractor.assets.ManifestEntry;

public class DownloadFile extends RiftAction
{
	@Option(name = "-filename", usage = "The name or filename hash of the file", required = true)
	File filenameOrHash;

	@Option(name = "-outfilename", usage = "File file to write to", required = true)
	File filenameOutput;

	@Option(name = "-release", usage = "Release to download from", required = true)
	ReleaseType releaseType;

	@Option(name = "-lang", usage = "Language, defaults to english")
	int lang = -1;

	@Option(name = "-pIndex", usage = "Patch Index")
	int patchIndex = -1;
	@Option(name = "-hash", usage = "Interpret -filename as a raw hash (8 hex chars) instead of a filename")
	boolean isRawHash = false;

	@Option(name = "-64")
	boolean is64 = true;

	public DownloadFile()
	{

	}

	@Override
	public void go()
	{
		try
		{
			String fname = filenameOrHash.toString();

			if (isRawHash)
			{
				PatchInfo patch;
				if (patchIndex != -1)
					patch = RemotePAK.getPatch(releaseType, is64, patchIndex);
				else
					patch = RemotePAK.getCurrentPatch(releaseType, is64);

				if (patch == null)
					throw new RuntimeException("No patch found");

				byte[] manifestData = RemotePAK.downloadManifest(releaseType, patch, null);
				Manifest manifest = new Manifest(new ByteArrayInputStream(manifestData), is64);

				List<ManifestEntry> entries = manifest.getEntriesForNameHash(fname)
						.collect(Collectors.toList());
				for (ManifestEntry e : entries)
				{
					if ((e.lang == 0 || e.lang == lang) || lang == -1)
					{
						RemotePAK.extract(releaseType, manifest, e, filenameOutput.toString(),
								patch.getIndex());
						System.out.println("Downloaded file [" + filenameOrHash + " ] to ["
								+ filenameOutput + "]");
						return;
					}
				}
				throw new IllegalArgumentException(
						"Unable to find entry for hash '" + fname + "'");
			}

			if (patchIndex != -1)
			{
				PatchInfo patch = RemotePAK.getPatch(releaseType, is64, patchIndex);
				if (patch == null)
					throw new RuntimeException("No patch found at index " + patchIndex);

				// if requesting the manifest itself, download and save directly
				if (fname.equals("assets64.manifest") || fname.equals("recovery64.manifest")
						|| fname.equals("assets32.manifest") || fname.equals("recovery/recovery.manifest")
						|| fname.equals("recovery64/recovery64.manifest"))
				{
					byte[] data = RemotePAK.downloadManifest(releaseType, patch, null);
					try (FileOutputStream fos = new FileOutputStream(filenameOutput))
					{
						fos.write(data);
					}
				} else
				{
					RemotePAK.downloadLatest(releaseType, patch, fname,
							filenameOutput.toString(), lang);
				}
			} else
			{
				RemotePAK.downloadLatest(releaseType, fname, filenameOutput.toString(), lang, is64);
			}
			System.out.println("Downloaded file [" + filenameOrHash + " ] to [" + filenameOutput + "]");
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
