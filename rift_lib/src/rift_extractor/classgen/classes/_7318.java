package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7318 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7318")
public class _7318 extends _999519
{
	public _7318(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7318);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
