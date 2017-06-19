package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1934 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1934")
public class _1934 
{
	public _1934(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1934);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
