package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3028 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3028")
public class _3028 
{
	public _3028(){}
	java.lang.String unk0;
	java.util.HashMap<java.lang.Long,_3030> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3028);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
