package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 4320 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4320")
public class _4320
{
	public _4320()
	{
	}

	public java.lang.String unk0;
	java.lang.Boolean unk1;
	java.lang.Long unk2;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 4320);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class, obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 2);
	}
}
