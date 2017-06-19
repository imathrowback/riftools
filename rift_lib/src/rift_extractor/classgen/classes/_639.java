package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 639 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_639")
public class _639 
{
	public _639(){}
	Object unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;
	Object unk4;
	java.lang.Long unk5;
	java.lang.Boolean unk6;
	java.util.List<java.lang.Long> unk7;
	java.lang.Long unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 639);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
	}
}
