/*
 *
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class CLongConvertor extends CObjectConverter<Long>
{

	public CLongConvertor()
	{
	}

	@Override
	public Long convert(final CObject obj) throws Exception
	{
		if (obj.data.length == 1)
		{
			boolean b = getDIS(obj).readBoolean();
			return Long.parseLong("" + (b ? "1" : "0"));
		} else
			return getDIS(obj).readLong();
	}

}
