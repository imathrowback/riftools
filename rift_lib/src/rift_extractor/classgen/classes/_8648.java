package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8648 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8648")
public class _8648 
{
	public _8648(){}
	Object unk0;
	java.lang.Long unk1;
	java.lang.Float unk2;
	java.lang.Long unk3;
	java.lang.Float unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8648);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
	}
}
