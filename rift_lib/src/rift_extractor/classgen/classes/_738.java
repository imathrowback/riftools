package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 738 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_738")
public class _738 
{
	public _738(){}
	Object unk0;
	java.lang.Boolean unk1;
	TextEntry unk2;
	TextEntry unk3;
	java.lang.String unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 738);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(TextEntry.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
	}
}
