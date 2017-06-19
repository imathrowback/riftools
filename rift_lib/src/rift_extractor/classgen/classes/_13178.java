package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13178 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13178")
public class _13178 
{
	public _13178(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	Object unk2;
	public java.lang.Float unk3;
	public java.lang.Long unk4;
	public java.lang.Float unk5;
	public java.lang.Float unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13178);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
	}
}
