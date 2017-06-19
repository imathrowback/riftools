package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13003 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13003")
public class _13003 
{
	public _13003(){}
	java.util.List<_13002> unk0;
	java.util.List<java.lang.Long> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13003);

		unk0 = ClassUtils.list(_13002.class,obj,0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
	}
}
