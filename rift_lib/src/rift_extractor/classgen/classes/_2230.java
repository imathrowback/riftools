package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2230 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2230")
public class _2230 
{
	public _2230(){}
	Object unk0;
	java.lang.Boolean unk1;
	java.lang.Long unk2;
	Object unk3;
	java.lang.Long unk4;
	java.util.List<java.lang.Long> unk5;
	java.lang.Float unk6;
	Object unk7;
	Object unk8;
	java.lang.Boolean unk9;
	java.lang.Long unk10;
	Object unk11;
	Object unk12;
	Object unk13;
	java.lang.Boolean unk14;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2230);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(Object.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 14);
	}
}
