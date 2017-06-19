package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13152 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13152")
public class _13152 extends _999505
{
	public _13152(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13152);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
