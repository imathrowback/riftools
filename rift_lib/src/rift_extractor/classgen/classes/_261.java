package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 261 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_261")
public class _261 
{
	public _261(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_265> unk0;
	java.util.List<java.lang.Long> unk1;
	java.util.List<_288> unk2;
	java.util.List<_269> unk3;
	java.util.List<_287> unk4;
	java.util.List<_287> unk5;
	java.lang.String unk6;
	rift_extractor.classgen.Vector3 unk7;
	java.lang.Float unk8;
	java.lang.Float unk9;
	java.util.List<java.lang.Long> unk10;
	java.util.List<java.lang.Long> unk11;
	java.lang.String unk12;
	java.util.List<java.lang.Long> unk13;
	java.util.List<_287> unk14;
	java.lang.String unk15;
	java.lang.String unk16;
	java.lang.String unk17;
	java.util.List<java.lang.Long> unk18;
	java.util.List<java.lang.Long> unk19;
	java.util.List<java.lang.Long> unk20;
	java.util.List<java.lang.String> unk21;
	java.lang.String unk22;
	java.lang.Float unk23;
	java.lang.Float unk24;
	java.lang.Float unk25;
	java.lang.Float unk26;
	rift_extractor.classgen.Vector3 unk27;
	Object unk28;
	Object unk29;
	java.util.HashMap<java.lang.Long,_248> unk30;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 261);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.list(_288.class,obj,2);
		unk3 = ClassUtils.list(_269.class,obj,3);
		unk4 = ClassUtils.list(_287.class,obj,4);
		unk5 = ClassUtils.list(_287.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.vector3(obj,7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
		unk10 = ClassUtils.list(java.lang.Long.class,obj,10);
		unk11 = ClassUtils.list(java.lang.Long.class,obj,11);
		unk12 = ClassUtils.getFieldMember(java.lang.String.class,obj, 12);
		unk13 = ClassUtils.list(java.lang.Long.class,obj,13);
		unk14 = ClassUtils.list(_287.class,obj,14);
		unk15 = ClassUtils.getFieldMember(java.lang.String.class,obj, 15);
		unk16 = ClassUtils.getFieldMember(java.lang.String.class,obj, 16);
		unk17 = ClassUtils.getFieldMember(java.lang.String.class,obj, 17);
		unk18 = ClassUtils.list(java.lang.Long.class,obj,18);
		unk19 = ClassUtils.list(java.lang.Long.class,obj,19);
		unk20 = ClassUtils.list(java.lang.Long.class,obj,20);
		unk21 = ClassUtils.list(java.lang.String.class,obj,21);
		unk22 = ClassUtils.getFieldMember(java.lang.String.class,obj, 22);
		unk23 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 23);
		unk24 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 24);
		unk25 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 25);
		unk26 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 26);
		unk27 = ClassUtils.vector3(obj,27);
		unk28 = ClassUtils.getFieldMember(Object.class,obj, 28);
		unk29 = ClassUtils.getFieldMember(Object.class,obj, 29);
		unk30 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 30);
	}
}
