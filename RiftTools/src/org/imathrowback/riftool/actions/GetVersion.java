package org.imathrowback.riftool.actions;

import java.io.IOException;

import org.imathrowback.manifest.PatchInfo;
import org.imathrowback.manifest.Versions;
import org.kohsuke.args4j.Option;

public class GetVersion extends RiftAction
{
	@Option(name = "-index", usage = "0 for A, 1 for B", required = true)
	int index;

	@Option(name = "-32")
	boolean is32 = false;

	@Override
	public void go() throws IOException
	{
		PatchInfo x = Versions.getVersion(index, !is32);
		System.out.println(x.getRelease());
	}
}
