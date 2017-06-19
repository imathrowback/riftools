package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2278 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2278")
public class _2278 
{
	public _2278(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2278);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
