package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3776 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3776")
public class _3776 
{
	public _3776(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3776);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
