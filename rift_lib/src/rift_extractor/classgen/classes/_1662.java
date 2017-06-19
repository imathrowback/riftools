package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1662 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1662")
public class _1662 extends _999561
{
	public _1662(){}
	java.lang.Float unk0;
	java.lang.Long unk1;
	Object unk2;
	java.lang.Long unk3;
	java.util.List<java.lang.Long> unk4;
	java.util.List<java.lang.Long> unk5;
	java.util.List<java.lang.Long> unk6;
	java.util.List<java.lang.Long> unk7;
	java.lang.Boolean unk8;
	java.lang.Long unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1662);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
	}
}
