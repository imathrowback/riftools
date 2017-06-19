package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1730 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1730")
public class _1730 extends _999539
{
	public _1730(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1730);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
