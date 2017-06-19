package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11560 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11560")
public class _11560 
{
	public _11560(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	Object unk2;
	public java.lang.Float unk3;
	public java.lang.Float unk4;
	public java.lang.Float unk5;
	public java.lang.Float unk6;
	public rift_extractor.classgen.Vector4 unk7;
	Object unk8;
	public java.lang.Float unk9;
	public java.lang.Float unk10;
	Object unk11;
	public java.lang.Float unk12;
	Object unk13;
	public java.lang.Float unk14;
	Object unk15;
	Object unk16;
	public java.lang.Long unk17;
	Object unk18;
	Object unk19;
	public _1935 unk20;
	public java.lang.Boolean unk21;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11560);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.vector4(obj,7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(Object.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(Object.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(Object.class,obj, 18);
		unk19 = ClassUtils.getFieldMember(Object.class,obj, 19);
		unk20 = ClassUtils.getFieldMember(_1935.class,obj, 20);
		unk21 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 21);
	}
}
