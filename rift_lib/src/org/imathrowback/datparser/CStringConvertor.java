/*
 *
 */
package org.imathrowback.datparser;

import java.nio.charset.Charset;

/**
 *
 * @author imathrowback
 */
public class CStringConvertor extends CObjectConverter<String>
{

	public CStringConvertor()
	{
	}

	@Override
	public String convert(final CObject obj) throws Exception
	{
		return new String(obj.data, Charset.forName("UTF-8"));
	}

}
