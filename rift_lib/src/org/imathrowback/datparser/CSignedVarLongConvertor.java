/*
 * 
 */
package org.imathrowback.datparser;

/**
 *
 * @author imathrowback
 */
public class CSignedVarLongConvertor extends CObjectConverter<Long>
{

	public CSignedVarLongConvertor()
	{
	}

	@Override
	public Long convert(CObject obj) throws Exception
	{
		return DatParser.readSignedVarLong(getDIS(obj), null);
	}
	
}
