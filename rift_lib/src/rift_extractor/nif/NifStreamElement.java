package rift_extractor.nif;

public class NifStreamElement
{

	public int dataType;
	public int offset;

	public NifStreamElement(final int count, final int size, final int dataType, final int offset)
	{
		this.count = count;
		this.size = size;
		this.dataType = dataType;
		this.offset = offset;
	}

	public int count;
	public int size;

}
