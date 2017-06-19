package rift_extractor.classgen;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("Vector4")
public class Vector4
{
	@XStreamAsAttribute
	public float v1;
	@XStreamAsAttribute
	public float v2;
	@XStreamAsAttribute
	public float v3;
	@XStreamAsAttribute
	public float v4;

	public Vector4(final float x, final float y, final float z, final float w)
	{
		v1 = x;
		v2 = y;
		v3 = z;
		v4 = w;
	}
}
