package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3548 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3548")
public class _3548 extends _999511
{
	public _3548(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3548);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
