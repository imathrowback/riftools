package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3034 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3034")
public class _3034 
{
	public _3034(){}
	java.lang.String unk0;
	Object unk1;
	Object unk2;
	java.lang.Float unk3;
	Object unk4;
	java.lang.Boolean unk5;
	java.lang.Float unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3034);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
	}
}
