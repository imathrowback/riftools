package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3843 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3843")
public class _3843 extends _999545
{
	public _3843(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Boolean unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3843);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
	}
}
