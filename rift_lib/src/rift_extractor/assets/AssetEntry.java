package rift_extractor.assets;

import org.apache.commons.codec.binary.Hex;

import rift_extractor.util.Util;

/** A single asset entry within the assets file */
public class AssetEntry
{
	public AssetEntry(final byte[] id, final int offset, final int size, final int sizeD, final int filenum,
			final int compressed,
			final byte[] hash, final AssetFile file)
	{
		this.id = id;
		strID = Util.bytesToHexString(id);
		this.sizeD = sizeD;
		this.offset = offset;
		this.size = size;
		this.compressed = compressed;
		this.hash = hash;
		this.file = file;
		this.filenum = filenum;
	}

	int filenum;
	final public AssetFile file;
	final public byte[] hash;
	final public int offset;
	final public int size;
	final public int compressed;
	final public byte[] id;
	final public String strID;
	final public int sizeD;

	@Override
	public String toString()
	{
		return "asset[" + strID + "][" + filenum + "] @ " + offset + ", size[" + size + "][" + sizeD + "], compressed["
				+ compressed
				+ "] file:" + file
				+ ", hash:" + Hex.encodeHexString(hash);
	}
}