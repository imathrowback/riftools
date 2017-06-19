package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7395 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7395")
public class _7395 
{
	public _7395(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_7396> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7395);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
