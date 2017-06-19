package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13002 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13002")
public class _13002 
{
	public _13002(){}
	java.util.List<_13000> unk0;
	Object unk1;
	java.lang.Boolean unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13002);

		unk0 = ClassUtils.list(_13000.class,obj,0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
	}
}
