package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 7628 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7628")
public class _7628
{
	public _7628()
	{
	}

	java.lang.String internalName;
	public TextEntry textName;
	public java.lang.Long renderableTemplate;
	java.lang.Long unk3;
	public java.lang.Long iconID_6009_6008;
	java.util.List<java.lang.Long> unk5;
	java.lang.Long unk6;
	java.lang.Boolean unk7;
	java.lang.Float unk8;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 7628);

		internalName = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
		textName = ClassUtils.getFieldMember(TextEntry.class, obj, 1);
		renderableTemplate = ClassUtils.getFieldMember(java.lang.Long.class, obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 3);
		iconID_6009_6008 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class, obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class, obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class, obj, 8);
	}
}
