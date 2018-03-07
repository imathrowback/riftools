package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1879 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1879")
public class _1879 
{
	public _1879(){}
	Object unk0;
	public java.lang.Long unk1;
	public java.util.List<java.lang.Long> unk2;
	Object unk3;
	Object unk4;
	public java.util.HashMap<java.lang.Long,_303> unk5;
	Object unk6;
	Object unk7;
	Object unk8;
	Object unk9;
	Object unk10;
	public TextEntry unk11;
	public java.lang.Long unk12;
	public TextEntry unk13;
	public TextEntry unk14;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1879);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(TextEntry.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(TextEntry.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(TextEntry.class,obj, 14);
	}
}
