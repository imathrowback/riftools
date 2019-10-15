package org.imathrowback.riftool.actions;

import java.io.File;

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
			if (patchIndex == -1)
				RemotePAK.downloadLatest(releaseType, filenameOrHash.toString(), filenameOutput.toString(), lang, is64);
			else
			{
				PatchInfo patch = RemotePAK.getPatches(releaseType, is64).get(patchIndex);
				RemotePAK.downloadLatest(releaseType, patch, filenameOrHash.toString(),
						filenameOutput.toString(), lang);
			}
			System.out.println("Downloaded file [" + filenameOrHash + " ] to [" + filenameOutput + "]");
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
