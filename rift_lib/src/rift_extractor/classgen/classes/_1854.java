package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1854 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1854")
public class _1854 
{
	public _1854(){}
	TextEntry unk0;
	TextEntry unk1;
	TextEntry unk2;
	TextEntry unk3;
	TextEntry unk4;
	TextEntry unk5;
	TextEntry unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1854);

		unk0 = ClassUtils.getFieldMember(TextEntry.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(TextEntry.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(TextEntry.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(TextEntry.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(TextEntry.class,obj, 6);
	}
}
