package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2201 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2201")
public class _2201 
{
	public _2201(){}
	Object unk0;
	TextEntry unk1;
	TextEntry unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.util.List<_2202> unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	Object unk8;
	Object unk9;
	Object unk10;
	java.lang.Long unk11;
	java.lang.Long unk12;
	java.lang.Long unk13;
	java.lang.Boolean unk14;
	java.util.List<_3733> unk15;
	Object unk16;
	java.lang.Long unk17;
	java.lang.Boolean unk18;
	java.lang.Boolean unk19;
	java.lang.Long unk20;
	java.lang.Long unk21;
	Object unk22;
	java.util.List<java.lang.Long> unk23;
	java.util.List<java.lang.Long> unk24;
	java.lang.Long unk25;
	Object unk26;
	Object unk27;
	java.lang.Boolean unk28;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2201);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.list(_2202.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 14);
		unk15 = ClassUtils.list(_3733.class,obj,15);
		unk16 = ClassUtils.getFieldMember(Object.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 18);
		unk19 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 19);
		unk20 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 20);
		unk21 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 21);
		unk22 = ClassUtils.getFieldMember(Object.class,obj, 22);
		unk23 = ClassUtils.list(java.lang.Long.class,obj,23);
		unk24 = ClassUtils.list(java.lang.Long.class,obj,24);
		unk25 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 25);
		unk26 = ClassUtils.getFieldMember(Object.class,obj, 26);
		unk27 = ClassUtils.getFieldMember(Object.class,obj, 27);
		unk28 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 28);
	}
}
