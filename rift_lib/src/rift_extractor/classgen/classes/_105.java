package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 105 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_105")
public class _105 
{
	public _105(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.String unk0;
	Object unk1;
	public java.lang.Long unk2;
	public java.lang.Long unk3;
	Object unk4;
	Object unk5;
	public java.lang.String unk6;
	public java.lang.String unk7;
	public java.util.List<_109> unk8;
	public java.util.List<_110> unk9;
	public java.util.List<_120> unk10;
	public java.util.List<_124> unk11;
	Object unk12;
	Object unk13;
	Object unk14;
	Object unk15;
	public java.util.List<_102> unk16;
	Object unk17;
	Object unk18;
	Object unk19;
	Object unk20;
	Object unk21;
	public java.util.List<_304> unk22;
	public ID unk23;
	public ID unk24;
	public java.lang.Long unk25;
	public java.lang.Long unk26;
	public java.lang.Long unk27;
	public java.lang.Long unk28;
	public java.lang.Boolean unk29;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 105);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.String.class,obj, 7);
		unk8 = ClassUtils.list(_109.class,obj,8);
		unk9 = ClassUtils.list(_110.class,obj,9);
		unk10 = ClassUtils.list(_120.class,obj,10);
		unk11 = ClassUtils.list(_124.class,obj,11);
		unk12 = ClassUtils.getFieldMember(Object.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(Object.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(Object.class,obj, 15);
		unk16 = ClassUtils.list(_102.class,obj,16);
		unk17 = ClassUtils.getFieldMember(Object.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(Object.class,obj, 18);
		unk19 = ClassUtils.getFieldMember(Object.class,obj, 19);
		unk20 = ClassUtils.getFieldMember(Object.class,obj, 20);
		unk21 = ClassUtils.getFieldMember(Object.class,obj, 21);
		unk22 = ClassUtils.list(_304.class,obj,22);
		unk23 = ClassUtils.getFieldMember(ID.class,obj, 23);
		unk24 = ClassUtils.getFieldMember(ID.class,obj, 24);
		unk25 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 25);
		unk26 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 26);
		unk27 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 27);
		unk28 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 28);
		unk29 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 29);
	}
}
