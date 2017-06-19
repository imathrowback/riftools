package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3163 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3163")
public class _3163 
{
	public _3163(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3163);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
