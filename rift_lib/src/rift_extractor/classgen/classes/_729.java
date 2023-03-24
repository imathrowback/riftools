package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 729 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_729")
public class _729
{
	public _729()
	{
	}

	public java.lang.String maleModel;
	java.util.List<java.lang.Long> unk1;
	public java.lang.String femaleModel;
	java.util.List<java.lang.Long> unk3;
	java.lang.String unk4;
	java.lang.String unk5;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 729);

		maleModel = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class, obj, 1);
		femaleModel = ClassUtils.getFieldMember(java.lang.String.class, obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class, obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class, obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class, obj, 5);
	}
}
