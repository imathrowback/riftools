package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1940 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1940")
public class _1940 
{
	public _1940(){}
	Object unk0;
	public java.util.List<java.lang.Long> unk1;
	public java.util.List<java.lang.Long> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1940);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
	}
}
