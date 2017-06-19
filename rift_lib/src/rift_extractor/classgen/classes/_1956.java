package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1956 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1956")
public class _1956 
{
	public _1956(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1956);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
