package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1103 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1103")
public class _1103 
{
	public _1103(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.Long unk1;
	public java.lang.Long unk2;
	public java.lang.Long unk3;
	public java.lang.Long unk4;
	public java.lang.Long unk5;
	public java.lang.Long unk6;
	public java.lang.Float unk7;
	public java.lang.Long unk8;
	public java.lang.Long unk9;
	public java.lang.Float unk10;
	Object unk11;
	Object unk12;
	public java.lang.Long unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1103);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(Object.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 13);
	}
}
