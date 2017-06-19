/*
 * 
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class CFloatConvertor extends CObjectConverter<Float>
{

	public CFloatConvertor()
	{
		
	}

	@Override
	public Float convert(CObject obj) throws Exception
	{
		return getDIS(obj).readFloat();
	}
	
}
