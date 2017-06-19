package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3600 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3600")
public class _3600 
{
	public _3600(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3600);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
