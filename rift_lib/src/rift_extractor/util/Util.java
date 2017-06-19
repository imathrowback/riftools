package rift_extractor.util;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import hasher.FNV1;
import rift_extractor.assets.AssetDatabase;
import rift_extractor.assets.AssetEntry;
import rift_extractor.assets.Manifest;

public class Util
{
	private static final ConcurrentMap<String, Object> locks = new ConcurrentHashMap<>();

	public static synchronized void extractResources(final AssetDatabase database, final Set<String> resources,
			final String outputDir)
			throws IOException
	{
		for (String texture : resources)
		{
			File file = new File(outputDir + texture);
			if (!file.exists())
			{
				Object lock = null;
				// Get a lock
				synchronized (locks)
				{
					lock = locks.get(file.getName());
					if (lock == null)
					{
						lock = new Object();
						locks.put(file.getName(), lock);
					}
				}
				synchronized (lock)
				{
					if (!file.exists())
					{
						try (FileOutputStream fos = new FileOutputStream(file))
						{
							extractFile(database, texture, fos);
						} catch (Exception ex)
						{
							System.err.println(ex);
						}
					}
				}
				synchronized (locks)
				{
					locks.remove(file.getName());
				}
			}
		}
	}

	public static void extractFile(final AssetDatabase database, final String filename, final OutputStream os)
			throws IOException
	{
		AssetEntry ae = database.getEntryForFileName(filename);
		extractEntry(database, ae, os);
	}

	public static void extractEntry(final AssetDatabase database, final AssetEntry ae, final OutputStream os)
			throws IOException
	{
		byte[] data = database.extract(ae);
		try (DataOutputStream dos = new DataOutputStream(os))
		{
			dos.write(data);
		}
	}

	public static LinkedHashSet<String> guessNIFResources(final byte[] data, final AssetDatabase database,
			final AssetEntry e)
	{
		if (!new String(data, 0, Math.min(100, data.length)).startsWith("Gamebryo File Format"))
			return null;

		Predicate<String> validName = (s) -> {
			try
			{
				if (!s.endsWith(".dds"))
					return false;
				database.getEntryForFileName(s);
				return true;
			} catch (Exception ex)
			{
				return false;
			}
		};
		LinkedHashSet<String> textures = Util.getFileFilenameStrings(Util.strings(data)).stream()
				.filter(s -> s.contains(".")).filter(validName).collect(Collectors.toCollection(LinkedHashSet::new));
		return textures;
	}

	/** Get a predicate that only files Gamebryo files */
	public static Predicate<? super AssetEntry> getOnlyNif(final AssetDatabase database)
	{
		return (e) -> {
			// we only need a few bytes, so only read the first few
			byte data[] = database.extractPart(e, 100);
			String s = new String(data, 0, Math.min(100, data.length));
			return (s.startsWith("Gamebryo File Format"));
		};
	}

	public static long getUnsignedInt(final int x)
	{
		return x & 0x00000000ffffffffL;
	}

	/**
	 * Given a filename and a manifest, hash the name and return the ID associated with the Asset Entry as 8 byte array. If no name could be found, return null.
	 *
	 * @param name The name to hash
	 * @param manifest THe manifest to search
	 * @return The 8 byte id or null if filename was not matched.
	 */
	public static byte[] findIDInManifestForFileName(final String name, final Manifest manifest)
	{
		return manifest.findID(hashFileName(name));

	}

	/**
	 * Given a filename and a manifest, hash the name and return the ID associated with the Asset Entry as 8 byte array. If no name could be found, return null.
	 *
	 * @param name The name to hash
	 * @param manifest THe manifest to search
	 * @return The 8 byte id or null if filename was not matched.
	 */
	public static String findIDAsStrInManifestForFileName(final String name, final Manifest manifest)
	{
		try
		{
			return manifest.filenameHashToID(hashFileName(name));
		} catch (IllegalArgumentException ex)
		{
			throw new IllegalArgumentException("Unable to find asset '" + name + "' in manifest", ex);
		}
	}

	public static String hashFileNameW(final String name)
	{
		try
		{

			byte[] bytes = name.toLowerCase().getBytes("UTF-16");
			int hash = FNV1.hash32W(bytes);
			String str = BigInteger.valueOf(getUnsignedInt(hash)).toString(16);
			return StringUtils.leftPad(str, 8, "0");
		} catch (Exception ex)
		{
			return hashFileName(name);
		}
	}

	public static String hashFileName(final String name)
	{
		String str = BigInteger.valueOf(getUnsignedInt(FNV1.hash32(name.toLowerCase().getBytes()))).toString(16);
		return StringUtils.leftPad(str, 8, "0");

	}

	public static int hashFileNameInt(final String name)
	{
		return FNV1.hash32(name.toLowerCase().getBytes());

	}

	/** Convert a sequence of bytes to a hex string */
	public static String bytesToHexString(final byte[] in)
	{
		return Hex.encodeHexString(in);
		/*
				final StringBuilder builder = new StringBuilder(in.length * 2);
				for (byte b : in)
				{
					builder.append(String.format("%02x", b));
				}
				return builder.toString();
				*/
	}

	/**
	 * attempt to extract all the ascii strings greater than 3 in length from the given byte data
	 *
	 * @param buf
	 * @return
	 */
	public static Collection<String> strings(final byte[] buf)
	{
		Set<String> strings = new TreeSet<>();
		try (ByteArrayInputStream dis = new ByteArrayInputStream(buf))
		{
			StringBuffer buffer = new StringBuffer();

			while (dis.available() > 0)
			{
				Character c = (char) (dis.read() & 0xff);
				// We only want ascii strings
				if (c >= 32 && c <= 126 && c != '?')
				{
					buffer.append(c);
				} else
				{
					if (buffer.length() > 3)
						strings.add(buffer.toString().trim());
					buffer.setLength(0);
				}
			}
			String string = buffer.toString().trim();
			if (string.length() > 3)
				strings.add(string);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return strings;

	}

	public static byte[] hexStringToBytes(final String id)
	{
		byte[] b = new byte[id.length() / 2];
		for (int i = 0, j = 0; i < id.length(); i += 2, j++)
		{
			String bt = id.substring(i, i + 2);

			b[j] = (byte) (Integer.valueOf(bt, 16) & 0xff);
		}

		return b;
	}

	public static List<String> getFileFilenameStrings(final Collection<String> inStrings)
	{
		Predicate<String> sF = (s) -> {
			if (s.length() >= 4)
				return s.contains(".");
			return false;
		};

		final List<String> strings = new LinkedList<>();
		for (String s : inStrings)
		{
			if (s.length() > 5)
				if (s.charAt(s.length() - 5) == '.')
					strings.add(s.substring(0, s.length() - 1));
			if (sF.test(s))
				strings.add(s);
			try
			{
				int lastSlash = s.lastIndexOf('/');
				if (lastSlash == -1)
					lastSlash = s.lastIndexOf('\\');
				if (lastSlash >= 0)
				{
					String newFile = s.substring(lastSlash + 1);
					if (newFile.length() >= 4)
						strings.add(newFile);
				}
			} catch (Exception ex)
			{

			}
		}

		List<String> newstrings = new LinkedList<>();
		for (String orig : strings)
		{
			String s = orig;
			if (s.charAt(orig.length() - 4) != '.' && s.charAt(orig.length() - 3) != '.')
			{
				continue;
			}

			//if (!Character.isAlphabetic(s.charAt(s.length() - 1)))
			//	s = s.substring(0, s.length() - 1);

			if (!isBad(s))
			{
				newstrings.add(s);
			}
		}

		return newstrings;
	}

	/** Test to see if there are any "bad" characters in the string and ensure the string is longer than 4 in length */
	private static boolean isBad(final String s)
	{
		if (s.length() <= 5)
			return true;
		String invalid = "' (){}&#%$@+?^><*:|\"";
		for (int i = 0; i < invalid.length(); i++)
			if (s.contains(invalid.substring(i, i + 1)))
			{
				return true;
			}
		return false;
	}

}
