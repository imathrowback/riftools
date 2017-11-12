package org.imathrowback.riftool;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.imathrowback.manifest.PatchInfo;
import org.imathrowback.manifest.ReleaseType;
import org.imathrowback.manifest.RemotePAK;
import org.imathrowback.riftool.actions.DownloadFile;
import org.imathrowback.riftool.actions.ExtractAll;
import org.imathrowback.riftool.actions.RiftAction;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionHandlerFilter;

public class RiftTool extends RiftAction
{

	public static void main(final String args[]) throws Exception
	{
		System.out.println("RiftTool");
		RiftTool rt = new RiftTool();
		rt.doMain(Arrays.asList(args));
	}

	public void printVersions() throws Exception
	{
		Map<Integer, PatchInfo> patches = RemotePAK.getPatches(ReleaseType.LIVE);
		System.out.println(patches);
	}

	public void download() throws Exception
	{

	}

	public void doMain(final Collection<String> args) throws Exception
	{
		List<String> largs = args.stream().collect(Collectors.toList());
		List<String> otherArgs = largs;
		int index = largs.indexOf("-action");
		if (index >= 0)
			otherArgs = largs.subList(index, index + 2);
		parse(this, otherArgs);

		// parse common arguments
		//System.out.println(args);
		//parse(this, args);

		switch (action)
		{
			case DOWNLOADFILE:
				DownloadFile df = new DownloadFile();
				parse(df, args);
				df.go();
				return;
			case NONE:
				return;
			case PRINTVERSIONS:
				printVersions();
				return;
			case EXTRACTALL:
				ExtractAll eAll = new ExtractAll();
				parse(eAll, args);
				eAll.go();
				return;
		}
	}

	static private void parse(final Object obj, final Collection<String> args)
	{
		CmdLineParser parser = new CmdLineParser(obj);
		parser.setUsageWidth(80);
		try
		{

			// parse the arguments.
			parser.parseArgument(args);
		} catch (CmdLineException e)
		{
			System.err.println(e.getMessage());
			System.err.println("java RiftTool [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// print option sample. This is useful some time
			System.err.println("  Example: java RiftTool" + parser.printExample(OptionHandlerFilter.ALL));
			return;
		}

	}

	@Override
	public void go()
	{
		// TODO Auto-generated method stub

	}

}
