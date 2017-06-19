package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7401 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7401")
public class _7401 
{
	public _7401(){}
	java.lang.String unk0;
	java.util.HashMap<java.lang.Long,_7395> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7401);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
