package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3631 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3631")
public class _3631 
{
	public _3631(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.Long unk1;
	public java.lang.Float unk2;
	public java.lang.Float unk3;
	Object unk4;
	public java.lang.Float unk5;
	public java.lang.Float unk6;
	public java.lang.Float unk7;
	public java.util.List<java.lang.Long> unk8;
	Object unk9;
	public java.util.List<java.lang.Long> unk10;
	public java.lang.Long unk11;
	public java.lang.Long unk12;
	Object unk13;
	Object unk14;
	public java.lang.Float unk15;
	Object unk16;
	Object unk17;
	public java.util.List<java.lang.Long> unk18;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3631);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.list(java.lang.Long.class,obj,8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.list(java.lang.Long.class,obj,10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(Object.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(Object.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(Object.class,obj, 17);
		unk18 = ClassUtils.list(java.lang.Long.class,obj,18);
	}
}
