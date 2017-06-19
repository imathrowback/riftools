/*
 *
 */
package org.imathrowback.datparser;

import com.google.common.io.LittleEndianDataInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;

/**
 *
 * @author imathrowback
 */
public abstract class CObjectConverter<T>
{
	boolean littleEndian = true;

	private DataInputStream getBEDIS(final byte[] data)
	{
		return new DataInputStream(new ByteArrayInputStream(data));
	}

	private LittleEndianDataInputStream getLEDIS(final byte[] data)
	{
		return new LittleEndianDataInputStream(new ByteArrayInputStream(data));
	}

	public DataInput getDIS(final CObject obj)
	{
		if (littleEndian)
			return getLEDIS(obj.data);
		else
			return getBEDIS(obj.data);
	}

	public void setLittleEndian(final boolean b)
	{
		this.littleEndian = b;
	}

	public boolean isLittleEndian()
	{
		return this.littleEndian;
	}

	public abstract T convert(CObject obj) throws Exception;

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}

}
