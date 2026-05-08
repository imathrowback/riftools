package org.imathrowback.riftool.actions;

import java.io.File;

import org.kohsuke.args4j.Option;

public class CreateAssetWAD extends RiftAction
{
	@Option(name = "-infilename", usage = "The file to create an asset file out of", required = true)
	File filenameIn;

	@Option(name = "-assetOut", usage = "The filename to write the data to", required = true)
	File filenameOut;

	@Override
	public void go()
	{

	}
}
