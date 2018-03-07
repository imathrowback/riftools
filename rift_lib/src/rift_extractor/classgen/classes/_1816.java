package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1816 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1816")
public class _1816 
{
	public _1816(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	TextEntry unk2;
	TextEntry unk3;
	java.util.HashMap<java.lang.Long,_303> unk4;
	java.util.HashMap<java.lang.Long,_303> unk5;
	Object unk6;
	java.lang.Float unk7;
	java.util.List<java.lang.Long> unk8;
	java.util.List<java.lang.Long> unk9;
	Object unk10;
	Object unk11;
	TextEntry unk12;
	TextEntry unk13;
	TextEntry unk14;
	TextEntry unk15;
	TextEntry unk16;
	java.util.List<java.lang.Long> unk17;
	java.util.List<_1864> unk18;
	java.util.List<_1864> unk19;
	java.lang.String unk20;
	Object unk21;
	java.util.List<java.lang.Long> unk22;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1816);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(TextEntry.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.list(java.lang.Long.class,obj,8);
		unk9 = ClassUtils.list(java.lang.Long.class,obj,9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(TextEntry.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(TextEntry.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(TextEntry.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(TextEntry.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(TextEntry.class,obj, 16);
		unk17 = ClassUtils.list(java.lang.Long.class,obj,17);
		unk18 = ClassUtils.list(_1864.class,obj,18);
		unk19 = ClassUtils.list(_1864.class,obj,19);
		unk20 = ClassUtils.getFieldMember(java.lang.String.class,obj, 20);
		unk21 = ClassUtils.getFieldMember(Object.class,obj, 21);
		unk22 = ClassUtils.list(java.lang.Long.class,obj,22);
	}
}
