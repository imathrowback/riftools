package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.imathrowback.manifest.PatchInfo;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.kohsuke.args4j.Option;

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
