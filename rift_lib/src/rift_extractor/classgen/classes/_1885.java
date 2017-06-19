package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1885 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1885")
public class _1885 
{
	public _1885(){}
	Object unk0;
	java.lang.Long unk1;
	_1854 unk2;
	Object unk3;
	java.util.List<java.lang.Long> unk4;
	Object unk5;
	Object unk6;
	Object unk7;
	Object unk8;
	java.lang.Boolean unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1885);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_1854.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
	}
}
