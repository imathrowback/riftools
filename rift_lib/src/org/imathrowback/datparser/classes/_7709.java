package org.imathrowback.datparser.classes;

import org.imathrowback.datparser.CObject;

public class _7709
{
	public _7709()
	{
	}

	@Override
	public String toString()
	{
		return name;
	}

	public void parse(final CObject obj)
	{
		if (obj.type != 7709)
			throw new IllegalArgumentException("expected object 7709 got " + obj.type);

		if (obj.hasMember(1))
			name = obj.getString(1);
		else if (obj.hasMember(0))
			name = obj.getString(0);
		else
			name = "";
		//throw new IllegalArgumentException("unable to get name of object");
	}

	public String name;
}
