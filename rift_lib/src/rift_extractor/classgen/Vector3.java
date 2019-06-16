package rift_extractor.classgen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Vector3")
public class Vector3
{
	@XStreamAsAttribute
	public float v1;
	@XStreamAsAttribute
	public float v2;
	@XStreamAsAttribute
	public float v3;

	public Vector3(final float x, final float y, final float z)
	{
		v1 = x;
		v2 = y;
		v3 = z;
	}

	@Override
	public String toString()
	{
		return v1 + "," + v2 + "," + v3;
	}
}
