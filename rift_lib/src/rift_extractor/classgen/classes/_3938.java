package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3938 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3938")
public class _3938 
{
	public _3938(){}
	Object unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;
	Object unk3;
	public _3925 unk4;
	Object unk5;
	public java.lang.Float unk6;
	public java.lang.Float unk7;
	public java.lang.Float unk8;
	public _3925 unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3938);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(_3925.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(_3925.class,obj, 9);
	}
}
