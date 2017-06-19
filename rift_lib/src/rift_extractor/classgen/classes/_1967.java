package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1967 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1967")
public class _1967 
{
	public _1967(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.lang.String unk2;
	Object unk3;
	java.lang.Boolean unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	ID unk8;
	java.lang.Long unk9;
	Object unk10;
	Object unk11;
	java.lang.Boolean unk12;
	java.util.List<java.lang.Long> unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1967);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(ID.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 12);
		unk13 = ClassUtils.list(java.lang.Long.class,obj,13);
	}
}
