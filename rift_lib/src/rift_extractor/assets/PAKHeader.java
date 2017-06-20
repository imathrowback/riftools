package rift_extractor.assets;

import java.io.IOException;
import com.google.common.io.LittleEndianDataInputStream;

public class PAKHeader
{
	final public int version;
	final public int pakfileSize;
	/** 16 bytes */
	final public int headerSize;
	/** total size of the entry header minus the headerSize */
	final public int entryTableSize;
	final public int numEntries;

	public PAKHeader(final LittleEndianDataInputStream dis) throws IOException
	{
		version = dis.readInt();
		pakfileSize = dis.readInt();
		headerSize = dis.readInt();
		entryTableSize = dis.readInt();

		numEntries = entryTableSize / 60;
	}
}
