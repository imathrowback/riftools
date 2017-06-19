package rift_extractor.classgen.classes;

import org.imathrowback.datparser.CObject;
import rift_extractor.classgen.ClassUtils;

/** 4478 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4478")
public class _4478
{
	public _4478()
	{
	}

	public java.lang.String unk0;
	java.lang.String unk1;
	rift_extractor.classgen.Vector3 unk2;
	java.lang.Float unk3;
	Object unk4;
	java.lang.String unk5;
	Object unk6;
	java.lang.String unk7;
	java.lang.Long unk8;
	java.lang.Long unk9;
	ID unk10;
	java.lang.Long unk11;
	java.lang.Long unk12;

	public void parse(final CObject obj)
	{
		ClassUtils.assertType(obj, 4478);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class, obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class, obj, 1);
		unk2 = ClassUtils.vector3(obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class, obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class, obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class, obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class, obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.String.class, obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 9);
		unk10 = ClassUtils.getFieldMember(ID.class, obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class, obj, 12);
	}
}
