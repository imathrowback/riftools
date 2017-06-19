package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1948 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1948")
public class _1948 
{
	public _1948(){}
	Object unk0;
	java.lang.Long unk1;
	_1854 unk2;
	Object unk3;
	Object unk4;
	java.lang.Long unk5;
	Object unk6;
	Object unk7;
	java.util.List<java.lang.Long> unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1948);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_1854.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.list(java.lang.Long.class,obj,8);
	}
}
