package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6017 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6017")
public class _6017 
{
	public _6017(){}
	rift_extractor.classgen.Vector3 unk0;
	rift_extractor.classgen.Vector3 unk1;
	java.lang.Float unk2;
	rift_extractor.classgen.Vector3 unk3;
	rift_extractor.classgen.Vector3 unk4;
	rift_extractor.classgen.Vector3 unk5;
	java.lang.Float unk6;
	rift_extractor.classgen.Vector3 unk7;
	rift_extractor.classgen.Vector3 unk8;
	rift_extractor.classgen.Vector3 unk9;
	rift_extractor.classgen.Vector3 unk10;
	java.lang.Float unk11;
	java.lang.Float unk12;
	Object unk13;
	java.lang.Float unk14;
	Object unk15;
	Object unk16;
	java.lang.Float unk17;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6017);

		unk0 = ClassUtils.vector3(obj,0);
		unk1 = ClassUtils.vector3(obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.vector3(obj,3);
		unk4 = ClassUtils.vector3(obj,4);
		unk5 = ClassUtils.vector3(obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.vector3(obj,7);
		unk8 = ClassUtils.vector3(obj,8);
		unk9 = ClassUtils.vector3(obj,9);
		unk10 = ClassUtils.vector3(obj,10);
		unk11 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(Object.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(Object.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(Object.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 17);
	}
}
