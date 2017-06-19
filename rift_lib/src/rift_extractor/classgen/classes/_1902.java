package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1902 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1902")
public class _1902 
{
	public _1902(){}
	Object unk0;
	Object unk1;
	java.lang.Boolean unk2;
	java.lang.Float unk3;
	Object unk4;
	_1894 unk5;
	java.lang.Float unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1902);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(_1894.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
	}
}
