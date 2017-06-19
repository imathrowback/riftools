package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3835 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3835")
public class _3835 extends _999501
{
	public _3835(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3835);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
