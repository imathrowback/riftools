package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8545 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8545")
public class _8545 
{
	public _8545(){}
	Object unk0;
	Object unk1;
	public rift_extractor.classgen.Vector3 unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	Object unk7;
	Object unk8;
	Object unk9;
	public java.util.HashMap<java.lang.Long,_157> unk10;
	Object unk11;
	Object unk12;
	Object unk13;
	public java.lang.Float unk14;
	Object unk15;
	public java.lang.Long unk16;
	public java.lang.Long unk17;
	public java.lang.Long unk18;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8545);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.vector3(obj,2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(Object.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(Object.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 18);
	}
}
