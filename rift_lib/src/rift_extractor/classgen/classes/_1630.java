package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1630 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1630")
public class _1630 extends _999602
{
	public _1630(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1630);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
