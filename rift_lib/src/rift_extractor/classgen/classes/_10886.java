package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10886 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10886")
public class _10886 extends _999500
{
	public _10886(){}
	Object unk0;
	java.util.List<java.lang.Long> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10886);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
	}
}
