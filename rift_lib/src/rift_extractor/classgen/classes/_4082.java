package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4082 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4082")
public class _4082 
{
	public _4082(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4082);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
