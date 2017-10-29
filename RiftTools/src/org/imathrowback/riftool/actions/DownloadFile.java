package org.imathrowback.riftool.actions;

import org.kohsuke.args4j.Option;

public class DownloadFile extends RiftAction
{
	@Option(name = "-filename", usage = "The name or filename hash of the file")
	String filenameOrHash;

	public DownloadFile()
	{

	}

	@Override
	public void go()
	{
		//RemotePAK.download(releaseType, patch, filename, outputDir);
	}
}
