package org.imathrowback.datparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@XStreamAlias(value = "obj")
public class CObject
{
	@XStreamAsAttribute
	public Integer type;
	@XStreamOmitField
	public byte[] data;

	public Object objData;
	@XStreamAsAttribute
	public Integer extracode;
	@XStreamAsAttribute
	public int index;
	@XStreamOmitField
	private CObjectConverter convertor;

	@XStreamAsAttribute
	public Long longValue;
	@XStreamAsAttribute
	public Integer intValue;
	@XStreamAsAttribute
	public String stringValue;

	@XStreamAsAttribute
	public String clazzName;

	public CObjectConverter getConvertor()
	{
		return convertor;
	}

	public void setConvertor(final CObjectConverter convertor)
	{
		this.convertor = convertor;

	}

	public Object convert()
	{
		try
		{
			if (longValue != null)
				return longValue;
			if (intValue != null)
				return intValue;
			if (stringValue != null)
				return stringValue;
			return getConvertor().convert(this);
		} catch (Exception ex)
		{
			return "";
		}
	}

	public CObject(final int type, final byte[] data, final int datacode, final CObjectConverter convertor)
	{
		this.type = type;
		extracode = datacode;
		index = extracode;
		this.data = data;
		this.convertor = convertor;
		try
		{
			if (convertor != null)
			{
				objData = convertor.convert(this);
				// It's extremely unlikely that floats or doubles represent very large or very small numbers. It is more likely they are ints or longs
				if (objData instanceof Float)
				{
					Float f = Math.abs((Float) objData);
					if (f > 100000000f || f < 0.000001f)
					{
						// This is probably a float
						this.convertor = new CIntConvertor();
						objData = this.convertor.convert(this);
					}
				} else if (objData instanceof Double)
				{
					Double f = Math.abs((Double) objData);
					if (f > 100000000 || f < 0.000001)
					{
						// This is probably a long
						//this.convertor = new CLongConvertor();
						//objData = this.convertor.convert(this);
					}
				}
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@XStreamOmitField
	CObject parent;

	@XStreamImplicit
	public List<CObject> members = new LinkedList<>();
	public Integer key;
	public Integer dataset;

	public void addMember(final CObject newObj)
	{
		members.add(newObj);
		newObj.parent = this;
	}

	@Override
	public String toString()
	{
		switch (type)
		{
			case 10:
			case 11:
				return "array: elements:" + extracode;

		}
		return "obj: " + type;
	}

	public CObject get(final int i)
	{
		return members.get(i);
	}

	public Map<Integer, CObject> getMap(final int index)
	{
		Map<Integer, CObject> map = new TreeMap<>();
		CObject obj = getAtIndex(index);
		for (int i = 0; i < obj.members.size(); i += 2)
		{
			Integer key = Integer.parseInt("" + obj.members.get(i).convert());
			CObject value = obj.members.get(i + 1);
			map.put(key, value);

		}
		return map;
	}

	public boolean hasClass(final int i)
	{
		for (CObject o : members)
			if (o.type == i)
				return true;
		return false;
	}

	public CObject getFirstClass(final int i)
	{
		for (CObject o : members)
			if (o.type == i)
				return o;
		return null;
	}

	public CObject getAtIndex(final int i)
	{
		for (CObject o : members)
			if (o.index == i)
				return o;
		return null;
	}

	public String getString(final int i)
	{
		return getAtIndex(i).convert() + "";

	}

	public Integer getInt(final int i)
	{
		try
		{
			CObject o = getAtIndex(i);
			return new CIntConvertor().convert(o);
		} catch (Exception ex)
		{
			return null;
		}
	}

	public Integer getInt(final int i, final int def)
	{
		try
		{
			return Integer.parseInt(getString(i));
		} catch (Exception ex)
		{
			return def;
		}
	}

	public boolean hasMember(final int i)
	{
		return getAtIndex(i) != null;
	}

	public boolean getBoolean(final int i, final boolean def)
	{
		try
		{
			return Boolean.parseBoolean(getString(i));
		} catch (Exception ex)
		{
			return def;
		}
	}

}