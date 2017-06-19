package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2239 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2239")
public class _2239 
{
	public _2239(){}
	Object unk0;
	Object unk1;
	java.lang.Long unk2;
	Object unk3;
	java.lang.Boolean unk4;
	java.util.List<java.lang.Long> unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2239);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
	}
}
