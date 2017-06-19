package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3934 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3934")
public class _3934 
{
	public _3934(){}
	java.lang.Boolean unk0;
	java.lang.Boolean unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3934);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
	}
}
