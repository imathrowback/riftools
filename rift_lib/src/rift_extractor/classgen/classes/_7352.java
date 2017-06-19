package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7352 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7352")
public class _7352 extends _999519
{
	public _7352(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7352);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
