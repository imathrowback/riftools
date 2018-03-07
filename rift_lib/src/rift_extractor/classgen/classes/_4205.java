package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4205 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4205")
public class _4205 
{
	public _4205(){}
	Object unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	java.lang.Boolean unk4;
	java.util.List<java.lang.Long> unk5;
	java.lang.Long unk6;
	java.util.List<_4206> unk7;
	TextEntry unk8;
	java.lang.Float unk9;
	java.lang.Long unk10;
	TextEntry unk11;
	TextEntry unk12;
	TextEntry unk13;
	java.lang.Boolean unk14;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4205);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.list(_4206.class,obj,7);
		unk8 = ClassUtils.getFieldMember(TextEntry.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(TextEntry.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(TextEntry.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(TextEntry.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 14);
	}
}
