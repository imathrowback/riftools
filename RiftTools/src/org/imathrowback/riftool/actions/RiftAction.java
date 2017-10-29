package org.imathrowback.riftool.actions;

import java.io.IOException;

import org.imathrowback.riftool.RiftToolAction;
import org.kohsuke.args4j.Option;

public abstract class RiftAction
{
	//@Option(name = "-release", usage = "The release type to use (required)", required = true)
	//protected ReleaseType release = ReleaseType.LIVE;

	@Option(name = "-action", usage = "The action to perform", required = true)
	protected RiftToolAction action = RiftToolAction.NONE;

	public abstract void go() throws IOException;
}
