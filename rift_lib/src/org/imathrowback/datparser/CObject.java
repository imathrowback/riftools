package org.imathrowback.datparser;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.util.LinkedList;
import java.util.List;

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
				objData = convertor.convert(this);
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
}