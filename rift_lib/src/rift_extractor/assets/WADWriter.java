package rift_extractor.assets;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

import com.google.common.io.Files;
import com.google.common.io.LittleEndianDataOutputStream;

import rift_extractor.util.Util;

public class WADWriter
{
	static class AssetOutEntry
	{
		public String name;
		public byte[] data;
		public int dataCompressedSize;
		public int dataDecompressedSize;
		public byte[] sha1Hash;
		public byte[] id;
		public int isCompressed = 1;

	}

	public static void main(final String[] args) throws Exception
	{
		String assetsManifest = "L:\\rift\\rift\\assets64.manifest";
		Manifest manifest = new Manifest(assetsManifest);

		List<AssetOutEntry> entries = new LinkedList<>();
		entries.add(fromFile(manifest, "PlayerPortrait.gfx", "L:\\rift\\rift\\PlayerPortrait.gfx"));

		entries.add(fromFile(manifest, "TargetPortrait.gfx", "L:\\rift\\rift\\TargetPortrait.gfx"));

		String wad = "L:\\rift\\rift\\Assets\\assets.999";
		new File(wad).delete();
		//writeWAD(wad, entries);

		WADWriter.writeWAD(wad, entries, manifest, "assets64.manifest");
		System.out.println("==> DONE");
	}

	public static AssetOutEntry fromFile(final Manifest manifest, final String originalName, final String path)
			throws Exception
	{
		return fromFile(manifest, originalName, Files.toByteArray(new File(path)));
	}

	public static AssetOutEntry fromFile(final Manifest manifest, final String originalName, final byte[] newData)
			throws Exception
	{
		AssetOutEntry ae = new AssetOutEntry();

		ManifestEntry entry = manifest.getEnglishEntry(originalName);
		byte[] hashOriginal = entry.shahash;

		ae.isCompressed = 0;
		byte[] data = newData;
		if (ae.isCompressed == 1)
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			DeflaterOutputStream dof = new DeflaterOutputStream(bos);
			dof.write(newData);
			dof.close();
			data = bos.toByteArray();
		}

		ae.data = data;
		ae.dataCompressedSize = ae.data.length;
		ae.dataDecompressedSize = newData.length;

		ae.sha1Hash = hashOriginal;
		ae.id = entry.id;
		//ArrayUtils.subarray(hashOriginal, 0, 8);

		return ae;
	}

	public static void writeWAD(final String wadFile, final List<AssetOutEntry> entries,
			final Manifest manifest,
			final String assetsManifestFilename)
			throws Exception
	{
		try (OutputStream fos = new BufferedOutputStream(new FileOutputStream(wadFile)))
		{
			try (LittleEndianDataOutputStream dos = new LittleEndianDataOutputStream(fos))
			{
				dos.write("TWAD".getBytes());
				dos.writeInt(1);
				dos.writeInt(20);
				dos.writeInt(1489);
				dos.writeInt(entries.size());

				int relOffset = 65536;
				int newIndex = 0;
				for (int i = 0; i < 1489; i++)
				{
					if (i < entries.size())
					{
						AssetOutEntry ae = entries.get(i);
						System.out
								.println(
										"\tWrite entry [" + Util.bytesToHexString(ae.id) + "][" + i + "][" + ae.name
												+ "] size " + ae.dataCompressedSize + "/"
												+ ae.dataDecompressedSize);
						dos.write(ae.id);
						dos.writeInt(relOffset);
						dos.writeInt(ae.dataCompressedSize);
						dos.writeInt(ae.dataCompressedSize);
						dos.writeShort(newIndex++);
						dos.writeShort(ae.isCompressed);
						dos.write(ae.sha1Hash);
						relOffset += ae.dataCompressedSize;

						// Update the manifest
						manifest.updateSize(ae.name, ae.id, ae.dataCompressedSize, ae.dataDecompressedSize,
								assetsManifestFilename);
					} else
					{
						dos.write(new byte[44]);
					}
				}
				for (int i = 0; i < entries.size(); i++)
				{
					AssetOutEntry ae = entries.get(i);
					fos.write(ae.data);
				}
			}
		}
	}
}
