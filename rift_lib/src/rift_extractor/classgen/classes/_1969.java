package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1969 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1969")
public class _1969 
{
	public _1969(){}
	java.lang.String unk0;
	TextEntry unk1;
	TextEntry unk2;
	java.lang.Float unk3;
	java.util.List<java.lang.Long> unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	java.lang.Boolean unk8;
	java.util.List<java.lang.Long> unk9;
	java.util.List<java.lang.Long> unk10;
	java.util.List<java.lang.Long> unk11;
	java.util.List<java.lang.Long> unk12;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1969);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
		unk9 = ClassUtils.list(java.lang.Long.class,obj,9);
		unk10 = ClassUtils.list(java.lang.Long.class,obj,10);
		unk11 = ClassUtils.list(java.lang.Long.class,obj,11);
		unk12 = ClassUtils.list(java.lang.Long.class,obj,12);
	}
}
