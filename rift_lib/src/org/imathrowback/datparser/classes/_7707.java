package org.imathrowback.datparser.classes;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.imathrowback.datparser.CObject;

public class _7707
{
	public Map<Long, _7709> map = new HashMap<>();

	public _7707()
	{

	}

	public void parse(final CObject obj)
	{
		if (obj.type != 7707)
			throw new IllegalArgumentException("expected object 7707 got " + obj.type);
		if (obj.hasMember(2))
		{
			CObject mary = obj.getAtIndex(2);
			decodeMap(mary, map);
		}
	}

	private static <T, U> void decodeMap(final CObject mary, final Map<T, U> map)
	{
		try
		{

			int count = mary.extracode;
			for (int i = 0; i < count * 2; i += 2)
			{
				CObject key = mary.get(i + 0);
				CObject value = mary.get(i + 1);

				int valueClass = value.type;
				Class<?> c = Class.forName("org.imathrowback.datparser.classes._" + valueClass);
				Method parse = c.getMethod("parse", CObject.class);
				U uinstance = (U) c.newInstance();
				parse.invoke(uinstance, value);
				map.put((T) key.convert(), uinstance);

			}
		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
	}
}
