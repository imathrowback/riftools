package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3932 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3932")
public class _3932 
{
	public _3932(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;
	public java.lang.Float unk3;
	public java.lang.Float unk4;
	Object unk5;
	public java.lang.Float unk6;
	public java.lang.Float unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3932);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
	}
}
