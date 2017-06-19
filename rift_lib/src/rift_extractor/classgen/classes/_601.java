package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 601 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_601")
public class _601 extends _999500
{
	public _601(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 601);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
