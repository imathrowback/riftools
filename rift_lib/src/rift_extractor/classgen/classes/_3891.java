package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3891 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3891")
public class _3891 
{
	public _3891(){}
	Object unk0;
	java.util.List<java.lang.Long> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3891);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
	}
}
