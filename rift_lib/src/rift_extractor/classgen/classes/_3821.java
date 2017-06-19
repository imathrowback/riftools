package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3821 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3821")
public class _3821 
{
	public _3821(){}
	Object unk0;
	Object unk1;
	public _4210 unk2;
	public java.lang.Long unk3;
	public java.lang.Long unk4;
	public java.util.List<java.lang.Long> unk5;
	public java.util.List<java.lang.Long> unk6;
	Object unk7;
	Object unk8;
	Object unk9;
	public java.util.List<java.lang.Long> unk10;
	public java.lang.Float unk11;
	public java.lang.Float unk12;
	public java.util.HashMap<java.lang.Long,_4655> unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3821);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_4210.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.list(java.lang.Long.class,obj,10);
		unk11 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 13);
	}
}
