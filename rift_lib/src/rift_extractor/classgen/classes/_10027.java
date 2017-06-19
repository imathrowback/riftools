package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10027 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10027")
public class _10027 
{
	public _10027(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10027);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
