package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1935 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1935")
public class _1935 
{
	public _1935(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;
	public java.lang.Float unk3;
	public java.lang.Float unk4;
	public java.util.HashMap<java.lang.Long,_307> unk5;
	public java.lang.Float unk6;
	public java.util.HashMap<java.lang.Long,_307> unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1935);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 7);
	}
}
