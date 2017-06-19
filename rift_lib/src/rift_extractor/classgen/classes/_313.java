package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 313 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_313")
public class _313 
{
	public _313(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 313);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
