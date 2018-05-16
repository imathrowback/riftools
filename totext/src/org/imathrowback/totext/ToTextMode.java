package org.imathrowback.totext;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerFilter;

public class ToTextMode
{
	enum FileType
	{
		CDS, DB
	}

	@Option(name = "-file", usage = "File to convert to text", metaVar = "FILE", required = true)
	private final File file = new File("");

	@Option(name = "-output", usage = "File to write the text to", metaVar = "FILE", required = true)
	private final File outputfile = new File("");

	@Option(name = "-fileType", usage = "File type of the given file", required = true)
	private FileType type;

	public static void main(final String[] args) throws Exception
	{
		ToTextMode mode = new ToTextMode();
		mode.doMain(Arrays.asList(args));
	}

	public void doMain(final Collection<String> argsList) throws Exception
	{
		CmdLineParser parser = new CmdLineParser(this);
		try
		{
			parser.setUsageWidth(80);
			parser.parseArgument(argsList);

			if (type == FileType.CDS)
				ExtractCDS.CDStoText(file, outputfile, ":", false);
			else
				new ToTextDB(file, outputfile).go();
		} catch (CmdLineException e)
		{
			// if there's a problem in the command line,
			// you'll get this exception. this will report
			// an error message.
			System.err.println(e.getMessage());
			System.err.println("java ToTextMode [options...] arguments...");
			// print the list of available options
			parser.printUsage(System.err);
			System.err.println();

			// print option sample. This is useful some time
			System.err.println("  Example: java ToTextMode" + parser.printExample(OptionHandlerFilter.ALL));
			return;
		}

	}

}
