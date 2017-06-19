package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8554 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8554")
public class _8554 
{
	public _8554(){}
	Object unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.Boolean unk2;
	ID unk3;
	java.lang.Float unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	java.util.List<_1832> unk8;
	java.lang.Float unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8554);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.list(_1832.class,obj,8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
	}
}
