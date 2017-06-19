package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 245 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_245")
public class _245 
{
	public _245(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 245);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
