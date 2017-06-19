package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13011 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13011")
public class _13011 
{
	public _13011(){}
	java.util.List<_13012> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13011);

		unk0 = ClassUtils.list(_13012.class,obj,0);
	}
}
