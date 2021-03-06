package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 703 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_703")
public class _703
{
	public _703()
	{
	}

	public Object unk0;
	public java.lang.Long unk1;
	public TextEntry unk2;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 703);

		unk0 = ClassUtils.getFieldMember(Object.class, obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class, obj, 2);
	}
}
