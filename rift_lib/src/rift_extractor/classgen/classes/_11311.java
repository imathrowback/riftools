package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11311 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11311")
public class _11311 
{
	public _11311(){}
	java.lang.String unk0;
	ID unk1;
	java.util.List<java.lang.Long> unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Boolean unk5;
	java.util.List<java.lang.Long> unk6;
	java.lang.Long unk7;
	java.util.List<java.lang.Long> unk8;
	java.lang.Float unk9;
	Object unk10;
	java.lang.String unk11;
	Object unk12;
	java.lang.Float unk13;
	java.lang.Float unk14;
	java.lang.Boolean unk15;
	java.lang.Boolean unk16;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11311);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.list(java.lang.Long.class,obj,8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.String.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(Object.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 16);
	}
}
