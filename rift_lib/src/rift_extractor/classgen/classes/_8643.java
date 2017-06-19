package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8643 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8643")
public class _8643 
{
	public _8643(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.Long unk1;
	public java.lang.Long unk2;
	public java.lang.Long unk3;
	public java.lang.Long unk4;
	public java.lang.Long unk5;
	public java.lang.Long unk6;
	public java.lang.Long unk7;
	public java.lang.Long unk8;
	public java.lang.Long unk9;
	public java.lang.Long unk10;
	public java.lang.Long unk11;
	public java.lang.Long unk12;
	public java.util.List<java.lang.Long> unk13;
	public java.lang.Float unk14;
	Object unk15;
	public java.util.List<java.lang.Long> unk16;
	public java.util.List<java.lang.Long> unk17;
	public java.util.List<java.lang.Long> unk18;
	Object unk19;
	public java.lang.Float unk20;
	public java.lang.Float unk21;
	public java.util.List<java.lang.Long> unk22;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8643);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.list(java.lang.Long.class,obj,13);
		unk14 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(Object.class,obj, 15);
		unk16 = ClassUtils.list(java.lang.Long.class,obj,16);
		unk17 = ClassUtils.list(java.lang.Long.class,obj,17);
		unk18 = ClassUtils.list(java.lang.Long.class,obj,18);
		unk19 = ClassUtils.getFieldMember(Object.class,obj, 19);
		unk20 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 20);
		unk21 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 21);
		unk22 = ClassUtils.list(java.lang.Long.class,obj,22);
	}
}
