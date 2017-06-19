/*
 * 
 */
package org.imathrowback.datparser;

import java.util.Objects;

/**
 *
 * @author imathrowback
 */
public class ConvertorInfo
{
	
	public ConvertorInfo(Class<? extends CObjectConverter> x)
	{
		this.x = x;
	}
	Class<? extends CObjectConverter> x;

	public Class<? extends CObjectConverter> getConvertorClass()
	{
		return x;
	}
	@Override
	public String toString()
	{
		return x.getSimpleName();
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 59 * hash + Objects.hashCode(this.x);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ConvertorInfo other = (ConvertorInfo) obj;
		return x.equals(other.x);
	}
	
	
	
}
