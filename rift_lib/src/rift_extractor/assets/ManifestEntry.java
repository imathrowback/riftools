package rift_extractor.assets;

import java.io.IOException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.io.LittleEndianDataInputStream;

import rift_extractor.util.Util;

public class ManifestEntry
{
	public String idStr;
	public String filenameHashStr;
	public final byte[] id;
	public final byte[] filenameHash;
	public final int pakOffset;
	public final int compressedSize;
	public final int size;
	public final short pakIndex;
	public final short w2;
	public final short w3;
	public final int w4;
	public final int lang;
	public final byte[] shahash;
	public final int unk;
	public String shaStr;

	public ManifestEntry(final LittleEndianDataInputStream dis) throws IOException
	{
		// read the ID of the entry
		id = new byte[8];
		dis.readFully(id);

		// read the filename hash of the entry
		filenameHash = new byte[4];
		dis.readFully(filenameHash);
		ArrayUtils.reverse(filenameHash);

		// store the ID and filename hash into a map for easy lookup
		idStr = Util.bytesToHexString(id);
		filenameHashStr = Util.bytesToHexString(filenameHash);

		pakOffset = dis.readInt();
		compressedSize = dis.readInt();
		size = dis.readInt();
		pakIndex = dis.readShort();

		//if (w1 > 2193)
		//	System.out.println(w1);
		w2 = dis.readShort();
		w3 = dis.readShort();
		w4 = dis.read();
		lang = dis.read();
		shahash = new byte[20];
		dis.read(shahash);
		unk = dis.readInt();
		shaStr = Util.bytesToHexString(shahash);
		//Date t = CFileTimeConvertor.readFileTime(dis);

	}

	@Override
	public String toString()
	{
		return ("[namehash]" + filenameHashStr + ":[partsha1sum]:" + idStr + ":[pakoffset]" +
				StringUtils.leftPad("" + pakOffset, 10, ' ') + ":[compressedSize]" +
				StringUtils.leftPad("" + compressedSize, 10, ' ') + ":[filesize]" + StringUtils.leftPad("" + size, 10, ' ')
				+ ":"
				+ "[PAKIndex]" + StringUtils.leftPad("" + pakIndex, 4, ' ') + ":[unkw2]"
				+ StringUtils.leftPad("" + w2, 6, ' ') + ":[lang]" + lang + ""
				+ ":[unk]" + unk
				+ ":[hash]:" + Util.bytesToHexString(shahash) + ":"
				+ unk);
	}

}