package org.imathrowback.totext;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class ToTextDB
{
	File in;
	File out;

	public ToTextDB(final File in, final File out)
	{
		this.in = in;
		this.out = out;
	}

	public void go() throws Exception
	{
		boolean encrypted = true;
		// First check if the DB is encrypted
		try (FileInputStream fis = new FileInputStream(in))
		{
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte[] header = new byte[16];
			bis.read(header);
			if (new String(header).contains("SQL"))
				encrypted = false;
		}

		// ok, so we should know if it's encrypted or not by now
		// Note that if the file is encrypted there is no way to tell if it is a *real* SQL DB or not until we decrypt it

	}
}
