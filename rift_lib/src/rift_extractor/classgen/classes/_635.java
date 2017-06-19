package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 635 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_635")
public class _635 
{
	public _635(){}
	Object unk0;
	java.lang.Long unk1;
	Object unk2;
	ID unk3;
	ID unk4;
	java.util.List<_3616> unk5;
	java.lang.Float unk6;
	java.lang.Long unk7;
	java.lang.Boolean unk8;
	java.lang.Boolean unk9;
	java.lang.Boolean unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 635);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(ID.class,obj, 4);
		unk5 = ClassUtils.list(_3616.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 10);
	}
}
