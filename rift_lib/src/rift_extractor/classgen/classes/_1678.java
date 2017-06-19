package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1678 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1678")
public class _1678 extends _999555
{
	public _1678(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	Object unk7;
	Object unk8;
	Object unk9;
	java.lang.Long unk10;
	java.util.List<java.lang.Long> unk11;
	java.util.List<java.lang.Long> unk12;
	java.util.List<java.lang.Long> unk13;
	java.lang.Long unk14;
	Object unk15;
	java.lang.Boolean unk16;
	java.lang.Long unk17;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1678);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
		unk11 = ClassUtils.list(java.lang.Long.class,obj,11);
		unk12 = ClassUtils.list(java.lang.Long.class,obj,12);
		unk13 = ClassUtils.list(java.lang.Long.class,obj,13);
		unk14 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(Object.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 17);
	}
}
