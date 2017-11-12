package org.imathrowback.riftool.actions;

import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.kohsuke.args4j.Option;

public class DownloadFile extends RiftAction
{
	@Option(name = "-filename", usage = "The name or filename hash of the file")
	String filenameOrHash;

	@Option(name = "-outfilename", usage = "File file to write to")
	String filenameOutput;

	@Option(name = "-release", usage = "Release to download from")
	ReleaseType releaseType;

	public DownloadFile()
	{

	}

	@Override
	public void go()
	{
		try
		{
			RemotePAK.downloadLatest(releaseType, filenameOrHash, filenameOutput);
			System.out.println("Downloaded file [" + filenameOrHash + " ] to [" + filenameOutput + "]");
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
