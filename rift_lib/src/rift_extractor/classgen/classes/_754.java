package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 754 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_754")
public class _754 
{
	public _754(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 754);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
