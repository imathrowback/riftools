package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2218 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2218")
public class _2218 
{
	public _2218(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.List<java.lang.Long> unk1;
	Object unk2;
	java.util.List<java.lang.Long> unk3;
	Object unk4;
	java.lang.Boolean unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2218);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
	}
}
