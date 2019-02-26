package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 10851 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10851")
public class _10851
{
	public _10851()
	{
	}

	public Object unk0;
	public Object unk1;
	public TextEntry unk2;
	public Object unk3;
	public Object unk4;
	public Object unk5;
	public java.lang.Long unk6;
	public java.lang.Long unk7;
	public java.lang.Long unk8;
	public java.lang.Long unk9;
	public java.lang.Long unk10;
	public java.lang.Long unk11;
	public TextEntry unk12;
	public java.lang.Long unk13;
	public java.util.HashMap<java.lang.Long, _303> unk14;
	public java.lang.Boolean unk15;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 10851);

		unk0 = ClassUtils.getFieldMember(Object.class, obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class, obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class, obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class, obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class, obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class, obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 11);
		unk12 = ClassUtils.getFieldMember(TextEntry.class, obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 13);
		unk14 = ClassUtils.getFieldMember(java.util.HashMap.class, obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Boolean.class, obj, 15);
	}
}
