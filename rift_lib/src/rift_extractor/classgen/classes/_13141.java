package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13141 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13141")
public class _13141 
{
	public _13141(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.List<_999505> unk1;
	java.lang.Long unk2;
	java.util.List<_13143> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13141);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.list(_999505.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.list(_13143.class,obj,3);
	}
}
