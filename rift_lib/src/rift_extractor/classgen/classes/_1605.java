package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1605 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1605")
public class _1605 extends _999569
{
	public _1605(){}
	Object unk0;
	java.util.List<_1850> unk1;
	java.util.List<java.lang.Long> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1605);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(_1850.class,obj,1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
	}
}
