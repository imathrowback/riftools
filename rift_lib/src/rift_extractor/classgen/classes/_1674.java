package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1674 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1674")
public class _1674 
{
	public _1674(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1674);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
