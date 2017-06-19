package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1739 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1739")
public class _1739 extends _999555
{
	public _1739(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	java.lang.Long unk7;
	java.lang.Long unk8;
	java.lang.Boolean unk9;
	Object unk10;
	java.lang.Long unk11;
	java.lang.Boolean unk12;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1739);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 12);
	}
}
