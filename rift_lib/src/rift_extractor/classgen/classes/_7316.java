package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7316 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7316")
public class _7316 extends _999519
{
	public _7316(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7316);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
