package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7714 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7714")
public class _7714 
{
	public _7714(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	TextEntry unk2;
	java.lang.Long unk3;
	java.lang.String unk4;
	java.lang.String unk5;
	java.util.HashMap<java.lang.Long,_6722> unk6;
	java.lang.Float unk7;
	java.lang.Boolean unk8;
	java.lang.Boolean unk9;
	java.lang.Boolean unk10;
	java.lang.String unk11;
	java.lang.Long unk12;
	java.lang.String unk13;
	java.lang.String unk14;
	java.lang.Boolean unk15;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7714);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.String.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.String.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.String.class,obj, 14);
		unk15 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 15);
	}
}
