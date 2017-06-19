package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import rift_extractor.classgen.ClassUtils;
import rift_extractor.classgen.Vector3;

/** 305 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_305")
public class _305
{
	public _305()
	{
	}

	//public rift_extractor.classgen.Vector3 unk0;
	@XStreamAsAttribute
	public float x;
	@XStreamAsAttribute
	public float y;
	@XStreamAsAttribute
	public float z;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 305);

		Vector3 v = ClassUtils.vector3(obj, 0);
		if (v != null)
		{
			x = v.v1;
			y = v.v2;
			z = v.v3;
		}

	}
}
