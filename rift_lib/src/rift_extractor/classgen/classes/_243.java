package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 243 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_243")
public class _243 
{
	public _243(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 243);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
