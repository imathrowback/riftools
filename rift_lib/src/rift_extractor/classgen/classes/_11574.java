package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11574 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11574")
public class _11574 extends _999501
{
	public _11574(){}
	Object unk0;
	java.lang.Boolean unk1;
	java.lang.Boolean unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11574);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
	}
}
