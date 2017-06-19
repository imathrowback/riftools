package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3000 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3000")
public class _3000 
{
	public _3000(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	java.lang.Boolean unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.util.List<_3039> unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3000);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.list(_3039.class,obj,5);
	}
}
