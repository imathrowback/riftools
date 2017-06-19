package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1669 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1669")
public class _1669 extends _999553
{
	public _1669(){}
	Object unk0;
	Object unk1;
	java.lang.Long unk2;
	Object unk3;
	java.util.List<java.lang.Long> unk4;
	java.util.List<java.lang.Long> unk5;
	java.util.List<java.lang.Long> unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1669);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
	}
}
