package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3935 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3935")
public class _3935 
{
	public _3935(){}
	Object unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;
	Object unk3;
	public _3925 unk4;
	public java.lang.Float unk5;
	public _3925 unk6;
	public java.lang.Float unk7;
	public java.lang.Float unk8;
	public java.lang.Float unk9;
	public java.lang.Float unk10;
	public _3925 unk11;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3935);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(_3925.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(_3925.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(_3925.class,obj, 11);
	}
}
