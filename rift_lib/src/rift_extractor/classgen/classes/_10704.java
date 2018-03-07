package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10704 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10704")
public class _10704 
{
	public _10704(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.util.List<_10705> unk2;
	java.lang.Boolean unk3;
	java.lang.Long unk4;
	Object unk5;
	Object unk6;
	java.lang.Long unk7;
	java.lang.String unk8;
	TextEntry unk9;
	TextEntry unk10;
	TextEntry unk11;
	java.util.List<java.lang.Long> unk12;
	java.lang.Boolean unk13;
	java.lang.Long unk14;
	java.lang.Boolean unk15;
	TextEntry unk16;
	Object unk17;
	java.lang.Boolean unk18;
	java.lang.Long unk19;
	java.util.List<java.lang.Long> unk20;
	java.lang.String unk21;
	Object unk22;
	java.lang.Long unk23;
	java.lang.String unk24;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10704);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.list(_10705.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.String.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(TextEntry.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(TextEntry.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(TextEntry.class,obj, 11);
		unk12 = ClassUtils.list(java.lang.Long.class,obj,12);
		unk13 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(TextEntry.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(Object.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 18);
		unk19 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 19);
		unk20 = ClassUtils.list(java.lang.Long.class,obj,20);
		unk21 = ClassUtils.getFieldMember(java.lang.String.class,obj, 21);
		unk22 = ClassUtils.getFieldMember(Object.class,obj, 22);
		unk23 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 23);
		unk24 = ClassUtils.getFieldMember(java.lang.String.class,obj, 24);
	}
}
