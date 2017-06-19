package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1807 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1807")
public class _1807 
{
	public _1807(){}
	Object unk0;
	java.lang.Long unk1;
	_1854 unk2;
	java.util.List<java.lang.Long> unk3;
	Object unk4;
	java.lang.Long unk5;
	java.util.List<_1875> unk6;
	Object unk7;
	java.util.List<java.lang.Long> unk8;
	java.lang.Boolean unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1807);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_1854.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.list(_1875.class,obj,6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.list(java.lang.Long.class,obj,8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
	}
}
