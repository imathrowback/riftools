package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1830 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1830")
public class _1830 
{
	public _1830(){}
	Object unk0;
	java.lang.Long unk1;
	ID unk2;
	java.lang.Float unk3;
	java.lang.Long unk4;
	Object unk5;
	java.lang.Long unk6;
	Object unk7;
	java.lang.Long unk8;
	java.lang.Long unk9;
	java.lang.Long unk10;
	java.util.List<java.lang.Long> unk11;
	java.util.List<_1832> unk12;
	java.lang.Float unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1830);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
		unk11 = ClassUtils.list(java.lang.Long.class,obj,11);
		unk12 = ClassUtils.list(_1832.class,obj,12);
		unk13 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 13);
	}
}
