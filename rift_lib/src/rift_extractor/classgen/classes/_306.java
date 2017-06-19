package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;

import rift_extractor.classgen.ClassUtils;

/** 306 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_306")
public class _306
{
	public _306()
	{
	}

	java.lang.String unk0;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 306);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
	}
}
