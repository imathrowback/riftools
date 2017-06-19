package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3929 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3929")
public class _3929 
{
	public _3929(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;
	public _3925 unk3;
	public java.lang.Long unk4;
	public java.lang.Long unk5;
	public _3925 unk6;
	public _3925 unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3929);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(_3925.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(_3925.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(_3925.class,obj, 7);
	}
}
