/*
 * 
 */
package org.imathrowback.datparser;

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
	public String convert(CObject obj) throws Exception
	{
		return new String(obj.data);
	}
	
}
