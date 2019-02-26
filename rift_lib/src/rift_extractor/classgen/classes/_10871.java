package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 10871 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10871")
public class _10871
{
	public _10871()
	{
	}

	public java.lang.Long unk0;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 10871);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 0);
	}
}
