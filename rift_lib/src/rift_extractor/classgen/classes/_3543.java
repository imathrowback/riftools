package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3543 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3543")
public class _3543 extends _999511
{
	public _3543(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3543);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
