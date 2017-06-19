package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13131 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13131")
public class _13131 
{
	public _13131(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13131);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
