package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3019 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3019")
public class _3019 
{
	public _3019(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;
	java.lang.Long unk4;
	java.lang.Float unk5;
	Object unk6;
	java.lang.Float unk7;
	Object unk8;
	Object unk9;
	Object unk10;
	java.lang.Boolean unk11;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3019);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 11);
	}
}
