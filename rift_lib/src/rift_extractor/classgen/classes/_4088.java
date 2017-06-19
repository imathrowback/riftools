package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4088 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4088")
public class _4088 
{
	public _4088(){}
	java.lang.String unk0;
	java.util.List<java.lang.Long> unk1;
	java.util.List<java.lang.Long> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4088);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
	}
}
