package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 6008 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6008")
public class _6008
{
	public _6008()
	{
	}

	public java.lang.String unk0;
	public java.lang.String unk1;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 6008);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class, obj, 1);
	}
}
