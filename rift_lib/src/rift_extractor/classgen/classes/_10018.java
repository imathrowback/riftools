package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 10018 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10018")
public class _10018
{
	public _10018()
	{
	}

	String internalName;
	public java.lang.String WiseEvent;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 10018);

		internalName = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
		WiseEvent = ClassUtils.getFieldMember(java.lang.String.class, obj, 1);
	}
}
