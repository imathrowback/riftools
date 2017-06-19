package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1734 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1734")
public class _1734 
{
	public _1734(){}
	Object unk0;
	Object unk1;
	java.util.List<java.lang.Long> unk2;
	java.lang.Boolean unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1734);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
	}
}
