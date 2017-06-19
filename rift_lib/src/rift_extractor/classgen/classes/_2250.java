package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2250 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2250")
public class _2250 
{
	public _2250(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2250);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
