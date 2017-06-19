package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3109 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3109")
public class _3109 
{
	public _3109(){}
	Object unk0;
	Object unk1;
	Object unk2;
	java.lang.Float unk3;
	java.lang.Boolean unk4;
	Object unk5;
	Object unk6;
	java.lang.Float unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3109);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
	}
}
