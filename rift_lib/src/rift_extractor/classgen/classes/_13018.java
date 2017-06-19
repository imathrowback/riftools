package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13018 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13018")
public class _13018 
{
	public _13018(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13018);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
