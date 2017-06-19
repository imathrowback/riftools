package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10872 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10872")
public class _10872 
{
	public _10872(){}
	java.lang.String unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	java.lang.Long unk4;
	Object unk5;
	java.lang.Float unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10872);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
	}
}
