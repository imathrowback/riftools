package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4044 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4044")
public class _4044 
{
	public _4044(){}
	Object unk0;
	TextEntry unk1;
	java.lang.Long unk2;
	Object unk3;
	java.lang.Long unk4;
	java.lang.Boolean unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	Object unk8;
	Object unk9;
	java.lang.Long unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4044);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
	}
}
