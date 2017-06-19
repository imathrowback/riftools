package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 9003 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_9003")
public class _9003 
{
	public _9003(){}
	Object unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Float unk4;
	java.util.List<java.lang.Long> unk5;
	java.lang.Long unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 9003);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
	}
}
