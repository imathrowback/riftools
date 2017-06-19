/*
 * 
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class CUnsignedVarLongConvertor extends CObjectConverter<Long>
{

	public CUnsignedVarLongConvertor()
	{
	}

	@Override
	public Long convert(CObject obj) throws Exception
	{
		return DatParser.readUnsignedVarLong(getDIS(obj), null);
	}
	
}
