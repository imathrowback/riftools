package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2253 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2253")
public class _2253 
{
	public _2253(){}
	Object unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	java.lang.Float unk6;
	TextEntry unk7;
	TextEntry unk8;
	TextEntry unk9;
	TextEntry unk10;
	java.lang.Long unk11;
	java.lang.Long unk12;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2253);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(TextEntry.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(TextEntry.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(TextEntry.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(TextEntry.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
	}
}
