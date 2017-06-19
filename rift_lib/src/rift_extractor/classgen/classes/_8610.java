package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8610 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8610")
public class _8610 
{
	public _8610(){}
	Object unk0;
	ID unk1;
	ID unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Boolean unk5;
	java.lang.Long unk6;
	java.util.List<java.lang.Long> unk7;
	java.lang.Boolean unk8;
	java.lang.Long unk9;
	java.lang.Long unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8610);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
	}
}
