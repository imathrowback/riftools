package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10881 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10881")
public class _10881 
{
	public _10881(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10881);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
