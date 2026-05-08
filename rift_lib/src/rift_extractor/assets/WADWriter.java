package rift_extractor.assets;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

import com.google.common.io.Files;
import com.google.common.io.LittleEndianDataOutputStream;

import rift_extractor.util.Util;

public class WADWriter
{
	public static class AssetOutEntry
	{
		public String name;
		public byte[] data;
		public int dataCompressedSize;
		public int dataDecompressedSize;
		public byte[] sha1Hash;
		public byte[] id;
		public int isCompressed = 0;
	}

	public static AssetOutEntry fromFile(final Manifest manifest, final String originalName, final String path)
			throws Exception
	{
		return fromFile(manifest, originalName, Files.toByteArray(new File(path)));
	}

	public static AssetOutEntry fromFile(final Manifest manifest, final String originalName, final byte[] newData)
			throws Exception
	{
		ManifestEntry entry = manifest.getEnglishEntry(originalName);
		if (entry == null)
			throw new IllegalArgumentException("Asset '" + originalName + "' not found in manifest");

		AssetOutEntry ae = new AssetOutEntry();
		ae.name = originalName;
		ae.isCompressed = 0;
		ae.data = newData;
		ae.dataCompressedSize = ae.data.length;
		ae.dataDecompressedSize = newData.length;
		ae.sha1Hash = entry.shahash;
		ae.id = entry.id;
		return ae;
	}

	public static void writeWAD(final String wadFile, final List<AssetOutEntry> entries,
			final Manifest manifest,
			final String assetsManifestFilename)
			throws Exception
	{
		int totalSlots = 1489;
		int headerSize = 20 + totalSlots * 44;
		int relOffset = headerSize;

		try (OutputStream fos = new BufferedOutputStream(new FileOutputStream(wadFile)))
		{
			try (LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(fos))
			{
				dos.write("TWAD".getBytes());
				dos.writeInt(1);
				dos.writeInt(20);
				dos.writeInt(totalSlots);
				dos.writeInt(entries.size());

				for (int i = 0; i < totalSlots; i++)
				{
					if (i < entries.size())
					{
						AssetOutEntry ae = entries.get(i);

						dos.write(ae.id);
						dos.writeInt(relOffset);
						dos.writeInt(ae.dataCompressedSize);
						dos.writeInt(ae.dataCompressedSize);
						dos.writeShort(i);
						dos.writeShort(ae.isCompressed);
						dos.write(ae.sha1Hash);
						relOffset += ae.dataCompressedSize;

						manifest.updateSize(ae.name, ae.id, ae.dataCompressedSize, ae.dataDecompressedSize,
								assetsManifestFilename);
					} else
					{
						dos.write(new byte[44]);
					}
				}
				for (AssetOutEntry ae : entries)
					fos.write(ae.data);
			}
		}
	}
}
