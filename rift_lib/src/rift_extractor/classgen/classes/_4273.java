package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4273 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4273")
public class _4273 
{
	public _4273(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4273);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
