package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11339 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11339")
public class _11339 
{
	public _11339(){}
	public java.lang.Float unk0;
	public java.lang.String unk1;
	public java.lang.String unk2;
	Object unk3;
	public java.lang.String unk4;
	public java.lang.String unk5;
	public java.lang.String unk6;
	public rift_extractor.classgen.Vector3 unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11339);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.vector3(obj,7);
	}
}
