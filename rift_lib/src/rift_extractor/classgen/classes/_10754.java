package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10754 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10754")
public class _10754 
{
	public _10754(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10754);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
