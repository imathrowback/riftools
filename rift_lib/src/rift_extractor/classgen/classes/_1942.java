package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1942 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1942")
public class _1942 
{
	public _1942(){}
	Object unk0;
	java.util.HashMap<java.lang.Long,_303> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1942);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
