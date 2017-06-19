package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1828 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1828")
public class _1828 
{
	public _1828(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_1829> unk0;
	java.util.HashMap<java.lang.Long,_6004> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1828);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
