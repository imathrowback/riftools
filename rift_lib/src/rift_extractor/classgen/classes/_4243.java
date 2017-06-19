package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4243 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4243")
public class _4243 
{
	public _4243(){}
	java.lang.String unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.String unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4243);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
	}
}
