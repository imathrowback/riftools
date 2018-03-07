package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3770 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3770")
public class _3770 
{
	public _3770(){}
	Object unk0;
	TextEntry unk1;
	java.util.List<_3507> unk2;
	Object unk3;
	java.util.List<java.lang.Long> unk4;
	java.lang.Long unk5;
	Object unk6;
	java.util.List<java.lang.Long> unk7;
	java.lang.Long unk8;
	java.util.List<java.lang.Long> unk9;
	Object unk10;
	java.lang.Long unk11;
	java.util.List<java.lang.Long> unk12;
	java.util.List<_1897> unk13;
	Object unk14;
	java.lang.Long unk15;
	java.lang.Long unk16;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3770);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.list(_3507.class,obj,2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.list(java.lang.Long.class,obj,9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.list(java.lang.Long.class,obj,12);
		unk13 = ClassUtils.list(_1897.class,obj,13);
		unk14 = ClassUtils.getFieldMember(Object.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 16);
	}
}
