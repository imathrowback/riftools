package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3818 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3818")
public class _3818 
{
	public _3818(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_303> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3818);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
