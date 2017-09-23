package org.imathrowback.manifest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.IOUtils;

public class NameDB
{
	static Map<String, String> hashNameMap;
	static String filename = "single-entries.dat";

	synchronized public static String getNameForHash(final String hash)
	{
		return getNameForHash(hash, hash);
	}

	synchronized public static String getNameForHash(final String hash, final String def)
	{
		if (hashNameMap == null)
		{
			hashNameMap = new TreeMap<>();
			try
			{
				InputStream is = null;
				if (new File(filename).exists())
					is = new FileInputStream(filename);
				else
					is = NameDB.class.getResourceAsStream(filename);
				try
				{

					GZIPInputStream singlezip = new GZIPInputStream(is);
					BufferedReader reader = new BufferedReader(new InputStreamReader(singlezip));
					for (String line : IOUtils.readLines(reader))
					{
						String[] name = line.split(":");
						if (name.length == 2)
							hashNameMap.put(name[0], name[1]);
					}
				} finally
				{
					if (is != null)
						is.close();
				}
			} catch (Exception ex)
			{
				System.err.println("Unable to read filenames.");
				ex.printStackTrace();
				return hash;
			}
		}
		return hashNameMap.getOrDefault(hash, def);
	}
}
