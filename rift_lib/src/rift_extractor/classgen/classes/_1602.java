package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1602 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1602")
public class _1602 extends _999552
{
	public _1602(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	Object unk2;
	Object unk3;
	java.lang.Float unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;
	Object unk7;
	Object unk8;
	Object unk9;
	java.lang.Float unk10;
	java.lang.Float unk11;
	java.lang.Float unk12;
	java.lang.Float unk13;
	Object unk14;
	java.lang.Long unk15;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1602);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(Object.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 15);
	}
}
