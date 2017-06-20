package org.imathrowback.manifest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.zip.GZIPInputStream;

import org.apache.commons.io.IOUtils;

import rift_extractor.assets.ManifestEntry;

public class NameDB
{
	static Map<String, String> hashNameMap;

	synchronized public static String getNameForHash(final String hash)
	{
		if (hashNameMap == null)
		{
			hashNameMap = new TreeMap<>();
			Function<ManifestEntry, String> hname = (n) -> hashNameMap.getOrDefault(n.filenameHashStr, "");
			try
			{
				GZIPInputStream singlezip = new GZIPInputStream(
						NameDB.class.getResourceAsStream("single-entries.dat"));
				BufferedReader reader = new BufferedReader(new InputStreamReader(singlezip));
				for (String line : IOUtils.readLines(reader))
				{
					String[] name = line.split(":");
					if (name.length == 2)
						hashNameMap.put(name[0], name[1]);
				}
			} catch (Exception ex)
			{
				System.err.println("Unable to read filenames.");
				ex.printStackTrace();
				return hash;
			}
		}
		return hashNameMap.getOrDefault(hash, hash);
	}
}
