package org.imathrowback.riftool.actions;

import java.io.File;

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

	public DownloadFile()
	{

	}

	@Override
	public void go()
	{
		try
		{
			RemotePAK.downloadLatest(releaseType, filenameOrHash.toString(), filenameOutput.toString());
			System.out.println("Downloaded file [" + filenameOrHash + " ] to [" + filenameOutput + "]");
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
