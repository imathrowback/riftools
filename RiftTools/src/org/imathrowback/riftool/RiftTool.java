package org.imathrowback.riftool;

import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.imathrowback.manifest.Versions;
import org.imathrowback.riftool.actions.*;
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

	public void printVersions(final boolean _is64) throws Exception
	{
		Versions.printVersions(_is64);
	}

	public void download() throws Exception
	{

	}

	public void doMain(final List<String> args) throws Exception
	{
		List<String> largs = args.stream().collect(Collectors.toList());
		List<String> otherArgs = largs;
		boolean is64 = largs.contains("-64");
		int index = largs.indexOf("-action");
		if (index >= 0)
			otherArgs = largs.subList(index, index + 2);
		if (!parse(this, otherArgs))
			return;

		// parse common arguments
		//System.out.println(args);
		//parse(this, args);

		RiftAction o = null;
		switch (action)
		{
			case EXTRACT_MINIONS:
				o = new MinionDatabase();
				break;
			case EXTRACT_VIG:
				o = new ExtractVignettes();
				break;
			case DOWNLOADFILE:
				o = new DownloadFile();
				break;
			case DECRYPTFILE:
				o = new DecryptDB();
				break;
			case EXTRACT_STRINGS:
				o = new ExtractDBStrings();
				break;
			case EXTRACT_LANG:
				o = new ExtractLanguageDB();
				break;
			case NONE:
				break;
			case PRINTVERSIONS:
				printVersions(is64);
				break;
			case GETVERSION:
				o = new GetVersion();
				break;
			case EXTRACT:
				o = new ExtractAll();
				break;
		}
		if (o != null)
			if (parse(o, args))
			{
				o.go();
			}

	}

	static OptionHandlerFilter optionHandlerFilter = (o) -> {
		String name = o.getNameAndMeta(null);
		return !name.startsWith("-action");
	};

	static private boolean parse(final Object obj, final List<String> args)
	{
		CmdLineParser parser = new CmdLineParser(obj);
		parser.setUsageWidth(80);
		try
		{

			// parse the arguments.
			parser.parseArgument(args);
			return true;
		} catch (CmdLineException e)
		{
			if (args.isEmpty() || args.size() <= 1)
			{
				System.err.println(e.getMessage());
				System.err.println("java RiftTool  [options...] arguments...");
				parser.printUsage(System.err);
				System.err.println();

				// print option sample. This is useful some time
				System.err
						.println("  Example: java RiftTool " + parser.printExample(OptionHandlerFilter.ALL));
				return false;
			} else
			{
				System.err.println(e.getMessage());
				System.err.println("java RiftTool " + args.get(0) + " " + args.get(1) + " [options...]");
				parser.printUsage(new OutputStreamWriter(System.err), null, optionHandlerFilter);
				System.err.println();

				// print option sample. This is useful some time
				System.err
						.println("  Example: java RiftTool " + args.get(0) + " " + args.get(1) + ""
								+ parser.printExample(optionHandlerFilter));
				return false;
			}
		}

	}

	@Override
	public void go()
	{
		// TODO Auto-generated method stub

	}

}
