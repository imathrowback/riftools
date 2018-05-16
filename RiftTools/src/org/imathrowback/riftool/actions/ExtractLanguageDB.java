package org.imathrowback.riftool.actions;

import java.io.File;
import java.io.IOException;

import org.imathrowback.totext.ExtractCDS;
import org.kohsuke.args4j.Option;

public class ExtractLanguageDB extends RiftAction
{
	@Option(name = "-filename", usage = "The filename of the CDS file to parse", required = true)
	File filename;

	@Option(name = "-output", usage = "The filename to write output to", required = true)
	File output;

	@Option(name = "-delim", usage = "Delimiter to use in the output, default is :")
	String delim = ":";

	@Option(name = "-convertNewLines", usage = "Convert newlines to a 'space' instead")
	boolean convertNewLines = false;

	@Override
	public void go() throws IOException
	{
		try
		{
			ExtractCDS.CDStoText(filename, output, delim, convertNewLines);
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}

	}

}
