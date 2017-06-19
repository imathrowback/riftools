package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2266 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2266")
public class _2266 
{
	public _2266(){}
	Object unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.Float unk2;
	Object unk3;
	java.lang.Boolean unk4;
	java.lang.Long unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2266);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
	}
}
