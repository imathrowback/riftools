package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10700 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10700")
public class _10700 
{
	public _10700(){}
	java.lang.String unk0;
	ID unk1;
	ID unk2;
	java.util.List<java.lang.Long> unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	Object unk6;
	Object unk7;
	java.lang.Long unk8;
	java.util.List<java.lang.Long> unk9;
	Object unk10;
	java.lang.Long unk11;
	java.util.List<java.lang.Long> unk12;
	java.util.List<java.lang.Long> unk13;
	java.util.List<java.lang.Long> unk14;
	Object unk15;
	java.lang.Long unk16;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10700);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.list(java.lang.Long.class,obj,9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.list(java.lang.Long.class,obj,12);
		unk13 = ClassUtils.list(java.lang.Long.class,obj,13);
		unk14 = ClassUtils.list(java.lang.Long.class,obj,14);
		unk15 = ClassUtils.getFieldMember(Object.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 16);
	}
}
