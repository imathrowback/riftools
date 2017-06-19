package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7321 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7321")
public class _7321 extends _999519
{
	public _7321(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7321);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
