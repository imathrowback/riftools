/*
 * 
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class CIntConvertor extends CObjectConverter<Integer>
{

	@Override
	public Integer convert(CObject obj) throws Exception
	{
		return getDIS(obj).readInt();
	}
	
}
