package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 640 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_640")
public class _640 
{
	public _640(){}
	Object unk0;
	java.lang.Long unk1;
	Object unk2;
	Object unk3;
	java.lang.Float unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	Object unk8;
	Object unk9;
	java.lang.Long unk10;
	java.lang.Float unk11;
	java.util.List<java.lang.Long> unk12;
	java.lang.Float unk13;
	java.lang.Float unk14;
	java.lang.Long unk15;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 640);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 11);
		unk12 = ClassUtils.list(java.lang.Long.class,obj,12);
		unk13 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 15);
	}
}
