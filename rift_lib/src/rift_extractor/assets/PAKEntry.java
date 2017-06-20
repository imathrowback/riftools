package rift_extractor.assets;

public class PAKEntry
{
	public int offset;
	public int compressedSize;
	public int uncompressedSize;
	public byte[] filenameHash;
	public String filenameHashStr;
	public String str;

	@Override
	public String toString()
	{
		return str;
	}
}