package rift_extractor.assets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.MessageFormat;

import com.google.common.io.LittleEndianDataInputStream;

import rift_extractor.util.Util;

public class ManifestPAKFileEntry
{
	public String hash1Str;
	public String hash2Str;
	public String combHash;

	public ManifestPAKFileEntry(final byte[] manifestData, final LittleEndianDataInputStream dis2) throws Exception
	{
		int offsetToName = dis2.readInt();
		name = readString(manifestData, offsetToName);
		fileSize1 = dis2.readInt();
		fileSize2 = dis2.readInt();
		compressionType = dis2.readByte();
		byte[] hash1 = new byte[20];
		dis2.read(hash1);
		byte[] hash2 = new byte[20];
		dis2.read(hash2);

		hash1Str = Util.bytesToHexString(hash1);
		hash2Str = Util.bytesToHexString(hash2);
		combHash = hash1Str + hash2Str;
		//System.out.println("\t" + Util.bytesToHexString(hash1) + ":" + Util.bytesToHexString(hash2));
	}

	private String readString(final byte[] manifestData, final int offset) throws IOException
	{
		LittleEndianDataInputStream dis2 = new LittleEndianDataInputStream(new ByteArrayInputStream(manifestData));
		dis2.skip(offset);
		StringBuffer buff = new StringBuffer();
		int x = 0;
		do
		{
			x = dis2.read();

			if (x != 0)
				buff.append((char) x);
		} while (x != 0);
		return buff.toString();
	}

	@Override
	public String toString()
	{
		return (MessageFormat.format(
				"{0} size1: {1}, size2:{2}: compressionType:{3}",
				name,
				fileSize1,
				fileSize2,
				compressionType));

	}

	public int getSize()
	{
		if (compressionType == 0)
			return fileSize1;
		else
			return fileSize2;
	}

	public String name;
	public int fileSize1;
	public int fileSize2;
	public byte compressionType;
	public byte[] hash1;
	public byte[] hash2;
}