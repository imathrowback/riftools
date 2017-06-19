package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10882 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10882")
public class _10882 extends _999500
{
	public _10882(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10882);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
