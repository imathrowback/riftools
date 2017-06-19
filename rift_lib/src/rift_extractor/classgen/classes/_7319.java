package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7319 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7319")
public class _7319 extends _999519
{
	public _7319(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7319);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
