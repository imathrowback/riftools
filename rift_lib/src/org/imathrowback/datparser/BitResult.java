package org.imathrowback.datparser;

public class BitResult
{
	public boolean fail = false;
	public int b;

	public BitResult(final int code, final int memberIndex)
	{
		this.code = code;
		data = memberIndex;
	}

	public int code;
	public int data;

	@Override
	public String toString()
	{
		return "c[" + code + "]d[" + data + "]";
	}
}