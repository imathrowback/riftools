package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1709 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1709")
public class _1709 extends _999571
{
	public _1709(){}
	Object unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	java.util.List<java.lang.Long> unk5;
	java.util.List<java.lang.Long> unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1709);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
	}
}
