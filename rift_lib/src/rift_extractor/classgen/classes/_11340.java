package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11340 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11340")
public class _11340 
{
	public _11340(){}
	java.lang.String unk0;
	TextEntry unk1;
	java.util.List<java.lang.Long> unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	java.util.List<java.lang.Long> unk6;
	java.lang.Long unk7;
	Object unk8;
	java.util.List<_11341> unk9;
	java.util.List<_11341> unk10;
	java.lang.String unk11;
	java.util.List<java.lang.Long> unk12;
	java.util.List<java.lang.Long> unk13;
	java.lang.Long unk14;
	java.util.List<java.lang.Long> unk15;
	java.util.List<java.lang.Long> unk16;
	java.lang.Float unk17;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11340);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.list(_11341.class,obj,9);
		unk10 = ClassUtils.list(_11341.class,obj,10);
		unk11 = ClassUtils.getFieldMember(java.lang.String.class,obj, 11);
		unk12 = ClassUtils.list(java.lang.Long.class,obj,12);
		unk13 = ClassUtils.list(java.lang.Long.class,obj,13);
		unk14 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 14);
		unk15 = ClassUtils.list(java.lang.Long.class,obj,15);
		unk16 = ClassUtils.list(java.lang.Long.class,obj,16);
		unk17 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 17);
	}
}
