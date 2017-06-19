package rift_extractor.assets;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.zip.InflaterInputStream;

import org.apache.commons.io.IOUtils;

import rift_extractor.util.Util;

/**
 * A single asset file contains the assets
 *
 */
public class AssetFile
{

	final public File file;
	boolean is64 = false;
	Map<String, AssetEntry> assets = new HashMap<>();

	@Override
	public String toString()
	{
		return file.getName();
	}

	public AssetFile(final File file) throws IOException
	{
		this.file = file;
		is64 = (file.getName().contains("64"));
	}

	public Stream<AssetEntry> getEntries()
	{
		return assets.values().stream();
	}

	void addAsset(final AssetEntry assetEntry)
	{
		if (assets.containsKey(assetEntry.strID))
			throw new IllegalArgumentException(
					"Asset key [" + assetEntry + "] already exists in db[" + assets.get(assetEntry.strID) + "]");
		assets.put(assetEntry.strID, assetEntry);
	}

	public boolean contains(final String id)
	{
		return assets.containsKey(id);
	}

	public boolean contains(final byte[] id)
	{
		String strID = Util.bytesToHexString(id);
		return assets.containsKey(strID);
	}

	public AssetEntry getEntry(final String strID)
	{
		return assets.get(strID);
	}

	public AssetEntry getEntry(final byte[] id)
	{
		String strID = Util.bytesToHexString(id);
		return assets.get(strID);
	}

	public synchronized byte[] extractWithoutDecompression(final AssetEntry entry) throws IOException
	{
		if (entry.file != this)
			throw new IllegalArgumentException(
					"Extract called on wrong asset file[" + file + "] for asset:" + entry);
		FileChannel fc;
		fc = FileChannel.open(file.toPath(), StandardOpenOption.READ);
		ByteBuffer data = ByteBuffer.allocate(entry.size);
		long bytesRead = fc.read(data, entry.offset);
		byte[] b = data.array();
		return b;
	}

	/**
	 * Attempt to extract the given assetentry into a byte array. Because the content may be compressed the returned byte array
	 * may be larger than the requested max bytes.
	 *
	 * @param entry The entry to read
	 * @param maxBytesToRead The maximum bytes to read from the source
	 * @return The bytes read, may be larger than requested if the data is compressed
	 */
	public synchronized byte[] extractPart(final AssetEntry entry, final int maxBytesToRead, final OutputStream os,
			final boolean nodecomp)
	{
		if (entry.file != this)
			throw new IllegalArgumentException(
					"Extract called on wrong asset file[" + file + "] for asset:" + entry);
		List<String> dbg = new LinkedList<>();

		try
		{
			FileChannel fc;
			fc = FileChannel.open(file.toPath(), StandardOpenOption.READ);
			if (nodecomp || (entry.compressed == 0))
			{
				// if not compressed
				ByteBuffer data = ByteBuffer.allocate(maxBytesToRead);
				long bytesRead = fc.read(data, entry.offset);
				if (entry.size >= maxBytesToRead && bytesRead != maxBytesToRead)
					throw new IllegalStateException(
							"Not enough bytes read, expected [" + maxBytesToRead + "], got: " + bytesRead);
				if (os != null)
				{
					os.write(data.array());
					return null;
				}
				byte[] b = data.array();
				/*
				String hash = DigestUtils.sha1Hex(b);
				String expected = Hex.encodeHexString(entry.hash);
				if (!hash.equals(expected))
					throw new IllegalStateException("hash not matched " + hash + ":" + expected);
				else
				{
					System.out.println("HASH MATCH:" + hash);
					System.out.println(entry);
				}
				*/
				return b;
			} else
			{
				// COMPRESSED

				// NOTE: entry.size doesn't indicate the size of the uncompressed data

				// Check if we want to read all the data or only a little
				boolean readAll = maxBytesToRead >= entry.size;

				FileChannelInputStream fcis = new FileChannelInputStream(fc, entry.offset, entry.size);
				byte[] cdata = new byte[entry.size];
				fcis.read(cdata);

				//System.out.println("byte[0]:" + cdata[0] + ":" + ":byte[1]:" + (cdata[1] & 0xff));
				InflaterInputStream zip = new InflaterInputStream(new ByteArrayInputStream(cdata));
				BufferedInputStream inf = new BufferedInputStream(zip);
				//System.out.println("seek to " + entry.offset + ", to decompress " + entry.size
				//	+ " bytes of data in " + file);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				byte b[] = new byte[4092];
				try
				{
					int n;
					while ((n = inf.read(b)) >= 0)
					{
						//System.out.println("decompressed " + n + " bytes");

						if (!readAll && out.size() >= maxBytesToRead)
							break;
						out.write(b, 0, n);
					}
					inf.close();
					zip.close();
					out.close();
					IOUtils.write(out.toByteArray(), os);

				} catch (Exception e)
				{
				}

				//if (readAll)
				//	throw new IllegalStateException(
				//			"size not matched " + b.length + ":" + entry.size + "," + entry.sizeD);
				/*String hash = DigestUtils.sha1Hex(b);
				String expected = Hex.encodeHexString(entry.hash);
				if (!hash.equals(expected))
					throw new IllegalStateException("hash not matched " + hash + ":" + expected);
				else
					System.out.println("HASH MATCH:" + hash);
				//return data;*/
				return out.toByteArray();

			}
		} catch (Exception ex)
		{
			String dbgOut = "";
			for (String s : dbg)
				dbgOut += s + "\n";
			throw new RuntimeException("failure in file " + file.getName() + ", @ " + entry.offset + ", id:"
					+ entry.strID + ", compressed?" + entry.compressed + ", filesize:" + entry.size + "\n\t" + dbgOut,
					ex);
		}
	}

	/** Attempt to extract the given assetentry into a byte array */
	public byte[] extract(final AssetEntry entry)
	{
		return extractPart(entry, entry.size, null, false);
	}

	public byte[] extract(final byte[] id)
	{
		String strID = Util.bytesToHexString(id);
		return extract(assets.get(strID));

	}

	public void extract(final AssetEntry entry, final OutputStream fos)
	{
		extractPart(entry, entry.size, fos, false);
	}

	public byte[] extractNoDecomp(final AssetEntry entry)
	{
		return extractPart(entry, entry.size, null, true);
	}

}