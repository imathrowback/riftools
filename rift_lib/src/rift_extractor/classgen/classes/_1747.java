package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1747 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1747")
public class _1747 extends _999553
{
	public _1747(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Float unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;
	java.util.List<java.lang.Long> unk4;
	java.util.List<java.lang.Long> unk5;
	java.util.List<java.lang.Long> unk6;
	java.util.List<java.lang.Long> unk7;
	java.util.List<java.lang.Long> unk8;
	java.lang.Boolean unk9;
	_1852 unk10;
	java.lang.Boolean unk11;
	java.lang.Float unk12;
	Object unk13;
	Object unk14;
	java.lang.Boolean unk15;
	Object unk16;
	java.lang.Float unk17;
	Object unk18;
	java.lang.Boolean unk19;
	java.lang.Boolean unk20;
	java.lang.Long unk21;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1747);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
		unk8 = ClassUtils.list(java.lang.Long.class,obj,8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(_1852.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(Object.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(Object.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(Object.class,obj, 18);
		unk19 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 19);
		unk20 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 20);
		unk21 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 21);
	}
}
