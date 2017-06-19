package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4010 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4010")
public class _4010 
{
	public _4010(){}
	java.lang.String unk0;
	java.lang.String unk1;
	rift_extractor.classgen.Vector3 unk2;
	rift_extractor.classgen.Vector3 unk3;
	java.lang.Float unk4;
	java.lang.Boolean unk5;
	java.lang.Boolean unk6;
	java.lang.Boolean unk7;
	rift_extractor.classgen.Vector4 unk8;
	java.lang.String unk9;
	Object unk10;
	Object unk11;
	java.lang.Float unk12;
	Object unk13;
	java.lang.Float unk14;
	java.lang.Float unk15;
	java.lang.Boolean unk16;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4010);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.vector3(obj,2);
		unk3 = ClassUtils.vector3(obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
		unk8 = ClassUtils.vector4(obj,8);
		unk9 = ClassUtils.getFieldMember(java.lang.String.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 16);
	}
}
