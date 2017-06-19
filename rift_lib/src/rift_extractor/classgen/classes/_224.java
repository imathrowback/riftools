package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 224 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_224")
public class _224 
{
	public _224(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;
	java.lang.Long unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;
	java.lang.Float unk7;
	java.lang.Float unk8;
	java.lang.Float unk9;
	java.lang.Float unk10;
	java.lang.Float unk11;
	java.lang.Long unk12;
	java.lang.Long unk13;
	java.lang.Long unk14;
	java.lang.Long unk15;
	java.lang.Long unk16;
	java.lang.Long unk17;
	java.lang.Long unk18;
	java.lang.Float unk19;
	rift_extractor.classgen.Vector4 unk20;
	java.lang.Float unk21;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 224);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 18);
		unk19 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 19);
		unk20 = ClassUtils.vector4(obj,20);
		unk21 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 21);
	}
}
