package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13000 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13000")
public class _13000 
{
	public _13000(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.HashMap<java.lang.Long,_313> unk1;
	java.util.HashMap<java.lang.Long,_13011> unk2;
	java.util.List<java.lang.Long> unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13000);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
	}
}
