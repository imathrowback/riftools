package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 285 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_285")
public class _285 
{
	public _285(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 285);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
