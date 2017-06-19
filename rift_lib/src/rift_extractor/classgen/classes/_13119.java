package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13119 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13119")
public class _13119 
{
	public _13119(){}
	java.util.List<_13118> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13119);

		unk0 = ClassUtils.list(_13118.class,obj,0);
	}
}
