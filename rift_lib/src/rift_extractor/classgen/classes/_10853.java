package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 10853 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10853")
public class _10853
{
	public _10853()
	{
	}

	public Object unk0;
	public java.util.HashMap<java.lang.Long, _10871> unk1;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 10853);

		unk0 = ClassUtils.getFieldMember(Object.class, obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class, obj, 1);
	}
}
