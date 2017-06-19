/*
 * 
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class CBooleanConvertor extends CObjectConverter<Boolean>
{

	public CBooleanConvertor()
	{
	}
	
	@Override
	public Boolean convert(CObject obj) throws Exception
	{
		return getDIS(obj).readBoolean();
	}

	
	
}
