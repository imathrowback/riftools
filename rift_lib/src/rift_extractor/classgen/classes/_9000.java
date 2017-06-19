package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 9000 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_9000")
public class _9000 
{
	public _9000(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 9000);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
