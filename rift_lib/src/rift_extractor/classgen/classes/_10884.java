package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10884 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10884")
public class _10884 extends _999500
{
	public _10884(){}
	java.lang.Boolean unk0;
	java.util.List<java.lang.Long> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10884);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
	}
}
