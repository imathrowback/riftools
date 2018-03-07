package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 628 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("HKXAndNIF")
public class HKXAndNIF 
{
	public HKXAndNIF(){}
	Object unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	java.util.List<_999519> unk4;
	Object unk5;
	java.util.List<java.lang.Long> unk6;
	TextEntry unk7;
	TextEntry unk8;
	Object unk9;
	TextEntry unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 628);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(_999519.class,obj,4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.getFieldMember(TextEntry.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(TextEntry.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(TextEntry.class,obj, 10);
	}
}
