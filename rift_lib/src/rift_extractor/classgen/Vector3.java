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
		this.v1 = x;
		this.v2 = y;
		this.v3 = z;
	}
}
