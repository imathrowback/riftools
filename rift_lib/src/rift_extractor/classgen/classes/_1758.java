package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1758 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1758")
public class _1758 
{
	public _1758(){}
	Object unk0;
	java.lang.Float unk1;
	Object unk2;
	Object unk3;
	java.lang.Long unk4;
	java.lang.Float unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1758);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
	}
}
