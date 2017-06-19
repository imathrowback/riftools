/*
 * 
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class CDoubleConvertor extends CObjectConverter<Double>
{

	public CDoubleConvertor()
	{
	}

	@Override
	public Double convert(CObject obj) throws Exception
	{
		return getDIS(obj).readDouble();
	}
	
}
