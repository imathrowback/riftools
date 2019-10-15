package org.imathrowback.riftool.actions;

import java.io.IOException;

import org.imathrowback.manifest.PatchInfo;
import org.imathrowback.manifest.Versions;
import org.kohsuke.args4j.Option;

public class GetVersion extends RiftAction
{
	@Option(name = "-index", usage = "0 for A, 1 for B", required = true)
	int index;

	@Option(name = "-64")
	boolean is64 = true;

	@Override
	public void go() throws IOException
	{
		PatchInfo x = Versions.getVersion(index, is64);
		System.out.println(x.getRelease());
	}
}
