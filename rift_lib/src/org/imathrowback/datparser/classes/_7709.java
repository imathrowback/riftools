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

		if (obj.members.size() == 1)
			name = (String) obj.get(0).convert();
		else if (obj.members.size() != 0)
			throw new IllegalArgumentException("members size was not 1");
	}

	public String name;
}
