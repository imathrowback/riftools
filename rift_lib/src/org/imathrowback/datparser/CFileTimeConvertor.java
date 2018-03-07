/*
 *
 */
package org.imathrowback.datparser;

import java.io.DataInput;
import java.util.Date;

/**
 *
 * @author imathrowback
 */
public class CFileTimeConvertor extends CObjectConverter<Date>
{

	public CFileTimeConvertor()
	{
	}

	@Override
	public Date convert(final CObject obj) throws Exception
	{
		return readFileTime(getDIS(obj));
	}

	public static final int NANO100_TO_MILLI = 10000;
	public static final long WINDOWS_TO_UNIX_EPOCH = 0x19DB1DED53E8000L;

	/**
	 * [MS-DTYP].pdf 2.3.3 FILETIME
	 *
	 * @return a Date converted from the Windows FILETIME stored in the buffer
	 * @throws Buffer.BufferException If an underflow occurs by reading the FILETIME (less than 8 bytes available).
	 */

	public static Date readFileTime(final DataInput diss) throws Exception
	{
		long lowOrder = diss.readInt();
		long highOrder = diss.readInt();
		long windowsTimeStamp = (highOrder << 32) | lowOrder;
		return new Date((windowsTimeStamp - WINDOWS_TO_UNIX_EPOCH) / NANO100_TO_MILLI);
	}
}
