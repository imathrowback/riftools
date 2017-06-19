package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3778 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3778")
public class _3778 
{
	public _3778(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_3779> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3778);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
