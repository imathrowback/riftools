package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7637 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7637")
public class _7637 
{
	public _7637(){}
	java.lang.String unk0;
	TextEntry unk1;
	java.util.List<java.lang.Long> unk2;
	java.lang.Boolean unk3;
	TextEntry unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7637);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(TextEntry.class,obj, 4);
	}
}
