package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 155 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_155")
public class _155 
{
	public _155(){}
	ID unk0;
	ID unk1;
	java.util.List<java.lang.Long> unk2;
	java.util.HashMap<java.lang.Long,_156> unk3;
	java.lang.Long unk4;
	java.util.HashMap<java.lang.Long,_3600> unk5;
	java.lang.Long unk6;
	java.util.List<java.lang.Long> unk7;
	java.util.HashMap<java.lang.Long,_157> unk8;
	java.lang.Float unk9;
	java.util.HashMap<java.lang.Long,_160> unk10;
	java.lang.Long unk11;
	java.lang.Boolean unk12;
	java.lang.Boolean unk13;
	java.lang.Long unk14;
	java.lang.Long unk15;
	Object unk16;
	java.lang.Boolean unk17;
	java.lang.Long unk18;
	java.lang.String unk19;
	java.util.List<java.lang.String> unk20;
	java.util.List<_313> unk21;
	java.lang.Float unk22;
	java.lang.Boolean unk23;
	java.util.HashMap<java.lang.Long,_156> unk24;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 155);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
		unk8 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(Object.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 17);
		unk18 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 18);
		unk19 = ClassUtils.getFieldMember(java.lang.String.class,obj, 19);
		unk20 = ClassUtils.list(java.lang.String.class,obj,20);
		unk21 = ClassUtils.list(_313.class,obj,21);
		unk22 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 22);
		unk23 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 23);
		unk24 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 24);
	}
}
