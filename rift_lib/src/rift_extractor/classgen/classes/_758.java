package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 758 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_758")
public class _758 
{
	public _758(){}
	Object unk0;
	public java.lang.Long unk1;
	public java.lang.Long unk2;
	public java.lang.Float unk3;
	public java.lang.Long unk4;
	public java.lang.Long unk5;
	public java.lang.Float unk6;
	public java.lang.Boolean unk7;
	public java.lang.Float unk8;
	public java.lang.Float unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 758);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
	}
}
