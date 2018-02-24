package rift_extractor.assets;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Stream;

import org.apache.commons.compress.utils.IOUtils;

import com.google.common.io.LittleEndianDataInputStream;

import rift_extractor.util.Util;

/**
 * Parse out a manifest file.
 * The manifest contains a bunch of data but the one we are most interested in the ID to Filename mapping.
 *
 *
 */
public class Manifest
{
	Map<String, String> fileNameHashIDMap = new TreeMap<>();
	public Map<String, List<ManifestEntry>> fileNameHashesIDMap = new TreeMap<>();
	Map<String, Set<String>> idToNameNameHashMap = new TreeMap<>();

	boolean is64;

	public Manifest(final InputStream str, final boolean _64)
	{
		is64 = _64;
		try
		{
			byte[] manifestData = IOUtils.toByteArray(str);
			processTable(manifestData);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public Manifest(final String assetsManifest)
	{
		is64 = (assetsManifest.contains("64"));

		try
		{
			byte[] manifestData = Files.readAllBytes(new File(assetsManifest).toPath());
			processTable(manifestData);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public Set<String> getIDs()
	{
		return idToNameNameHashMap.keySet();
	}

	public Set<String> getFileNameHashes()
	{
		return fileNameHashIDMap.keySet();
	}

	class TableEntry
	{
		int offset;
		int tableSize;
		int count;
		int stride;
		String name;

		public TableEntry(final String string, final LittleEndianDataInputStream dis) throws IOException
		{
			name = string;
			offset = dis.readInt();
			tableSize = dis.readInt();
			count = dis.readInt();
			stride = dis.readInt();
		}

		@Override
		public String toString()
		{
			int bytes = stride * count;
			int extra = tableSize - bytes;
			return (MessageFormat.format(
					"\t[" + name
							+ "]\n\ttableoffset:{0}\n\ttable size in bytes:{1}(extra: {4})\n\tcount:{2}\n\tstride:{3}\n",
					offset, tableSize, count, stride, extra));

		}
	}

	public List<ManifestPAKFileEntry> pakFiles = new ArrayList<>();
	public final List<ManifestEntry> manifestEntries = new LinkedList<>();
	public TreeMap<String, List<ManifestEntry>> manifestEntryMap = new TreeMap<>();

	private void processTable(final byte[] manifestData) throws Exception
	{
		// See http://forum.xentax.com/viewtopic.php?f=17&t=10119

		int tableOffset;
		int count;
		// read the manifest header
		try (LittleEndianDataInputStream dis = new LittleEndianDataInputStream(
				new ByteArrayInputStream(manifestData)))
		{
			byte[] twam = new byte[4];
			dis.readFully(twam);
			// These two are definitely version numbers
			short majorV = dis.readShort();
			short minorV = dis.readShort();
			//			System.out.println("Manifest version: " + majorV + "." + minorV);

			int _256tableoffset = dis.readInt();
			int _256 = dis.readInt();

			//			System.out.println("\tblock table offset:" + _256tableoffset + ", count:" + _256);
			//System.out.println("");
			TableEntry a = new TableEntry("pak table", dis);
			TableEntry b = new TableEntry("asset names", dis);
			TableEntry c = new TableEntry("unk", dis);

			tableOffset = b.offset;
			count = b.count;
			//System.out.println(a);
			//System.out.println(b);
			//System.out.println(c);

			// why is there a 256 table at the start?
			/** TABLE 0 - 256 byte table */
			byte[] table = new byte[256];
			for (int i = 0; i < _256; i++)
			{
				try (LittleEndianDataInputStream dis2 = new LittleEndianDataInputStream(
						new ByteArrayInputStream(manifestData, _256tableoffset + i, 1)))
				{
					table[i] = dis2.readByte();
				}
			}
			//System.out.println(Util.bytesToHexString(table));
			/** TABLE 1 - PAK files */
			for (int i = 0; i < a.count; i++)
			{
				try (LittleEndianDataInputStream dis2 = new LittleEndianDataInputStream(
						new ByteArrayInputStream(manifestData, a.offset + (i * a.stride), a.stride)))
				{
					pakFiles.add(new ManifestPAKFileEntry(manifestData, dis2));

				}
			}

			/** TABLE 3 - unknown? */
			//System.out.println(c.count);
			try (LittleEndianDataInputStream dis2 = new LittleEndianDataInputStream(
					new ByteArrayInputStream(manifestData, c.offset, c.tableSize)))
			{
				for (int i = 0; i < c.count; i++)
				{
					int ia = dis2.readInt() & 0xFFFFFF;
					int ecount = dis2.readInt();
					int offset = dis2.readInt();
					//System.out.println(MessageFormat.format("{0}:count:{1}:offset:{2}", ia, ecount, offset));
					try (LittleEndianDataInputStream dis3 = new LittleEndianDataInputStream(
							new ByteArrayInputStream(manifestData, offset, ecount * 4)))
					{
						for (int j = 0; j < ecount; j++)
						{
							//if (j < 20)
							//	System.out.println("[" + j + "]" + dis3.readInt());
						}
					}
				}

			}

			/** TABLE 2 - Manifest entries */
			int entrySize = b.stride;
			for (int i = 0; i < count; i++)
			{
				int start = tableOffset + (i * entrySize);

				try (LittleEndianDataInputStream dis2 = new LittleEndianDataInputStream(
						new ByteArrayInputStream(manifestData, start, entrySize)))
				{
					ManifestEntry entry = new ManifestEntry(dis2);
					//System.out.println(entry);
					manifestEntries.add(entry);

					if (!idEntryMap.containsKey(entry.idStr))
						idEntryMap.put(entry.idStr, new LinkedList<ManifestEntry>());
					idEntryMap.get(entry.idStr).add(entry);

					if (!idToNameNameHashMap.containsKey(entry.idStr))
						idToNameNameHashMap.put(entry.idStr, new TreeSet<String>());
					idToNameNameHashMap.get(entry.idStr).add(entry.filenameHashStr);

					if (!fileNameHashesIDMap.containsKey(entry.filenameHashStr))
						fileNameHashesIDMap.put(entry.filenameHashStr, new LinkedList<>());
					fileNameHashesIDMap.get(entry.filenameHashStr).add(entry);

					fileNameHashIDMap.put(entry.filenameHashStr, entry.idStr);
				}
			}
		}
	}

	public Stream<ManifestPAKFileEntry> getPAKs()
	{
		return pakFiles.stream();
	}

	public ManifestPAKFileEntry getPAK(final int index)
	{
		return pakFiles.get(index);
	}

	public String getPAKName(final int index)
	{
		return pakFiles.get(index).name;
	}

	public Map<String, List<ManifestEntry>> idEntryMap = new TreeMap<>();

	/**
	 * generates 32 bit pseudo-random numbers. Adapted from http://www.snippets.org
	 */
	public static int compute1(final int x)
	{
		int lo = 16807 * (x & 0xFFFF);
		int hi = 16807 * (x >>> 16);
		lo += (hi & 0x7FFF) << 16;
		if ((lo & 0x80000000) != 0)
		{
			lo &= 0x7fffffff;
			++lo;
		}
		lo += hi >>> 15;
		if (lo == 0 || (lo & 0x80000000) != 0)
		{
			lo &= 0x7fffffff;
			++lo;
		}
		return lo;
	}

	/**
	 * Check if the given filenam name hash exists in the manifest.
	 *
	 * Note that just because a hash exists in the manifest doesn't mean it actually has a corresponding asset file.
	 *
	 * @param filenameHash The hash to check
	 * @return True if the hash exists in the manifest, else false
	 */
	public boolean containsHash(final String filenameHash)
	{
		return fileNameHashIDMap.containsKey(filenameHash);
	}

	public boolean containsHash(final byte[] filenameHash)
	{
		return containsHash(Util.bytesToHexString(filenameHash));
	}

	public Set<String> getFilenameHashesForID(final String id)
	{
		if (idToNameNameHashMap.containsKey(id))
			return idToNameNameHashMap.get(id);
		return null;
	}

	/**
	 * Get the ID string for the given filename if it exists.
	 *
	 * @param filenameHash The hash to check
	 * @return The ID if we know it, else throw an exception
	 * @throws IllegalArgumentException If the filename was not found
	 */
	public String filenameHashToID(final String filenameHash)
	{
		String id = fileNameHashIDMap.get(filenameHash);
		if (id != null)
			return id;
		else
			throw new IllegalArgumentException("filename hash [" + filenameHash + "] not found in manifest");
	}

	/**
	 * Get the ID bytes for the given filename if it exists.
	 *
	 * @param filenameHash The hash to check
	 * @return The ID if we know it, else throw an exception
	 * @throws IllegalArgumentException If the filename was not found
	 */
	public byte[] findID(final String filenameHash)
	{
		String id = fileNameHashIDMap.get(filenameHash);
		if (id != null)
			return Util.hexStringToBytes(id);
		else
			throw new IllegalArgumentException("filename hash [" + filenameHash + "] not found in manifest");

	}

	public boolean getIs64()
	{
		return is64;
	}

	public ManifestEntry getEnglishEntry(final String filename)
	{
		String hash = Util.hashFileName(filename);
		for (ManifestEntry e : manifestEntries)
		{
			if (e.filenameHashStr.equals(hash))
			{
				if (e.lang == 0 || e.lang == 1)
					return e;
			}
		}
		return null;
	}

	public Stream<ManifestEntry> getEntries(final String strID)
	{
		return idEntryMap.get(strID).stream();
		//return manifestEntries.stream().filter(e -> e.idStr.equals(strID));

	}

	public Stream<ManifestEntry> getEntriesForNameHash(final String nameHash)
	{
		return manifestEntries.stream().filter(e -> e.filenameHashStr.equals(nameHash));

	}

}