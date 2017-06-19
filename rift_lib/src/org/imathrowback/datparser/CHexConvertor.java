/*
 *
 */
package org.imathrowback.datparser;

import org.apache.commons.lang3.ArrayUtils;

import rift_extractor.util.Util;

/**
 *
 * @author imathrowback
 */
public class CHexConvertor extends CObjectConverter<String>
{

	@Override
	public String convert(final CObject obj) throws Exception
	{
		if (obj.data == null)
			return "";
		byte[] copy = ArrayUtils.clone(obj.data);
		if (isLittleEndian())
			ArrayUtils.reverse(copy);
		return Util.bytesToHexString(copy);
	}

}
