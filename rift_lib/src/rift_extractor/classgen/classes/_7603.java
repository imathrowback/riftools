package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7603 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7603")
public class _7603 
{
	public _7603(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	java.lang.Float unk2;
	TextEntry unk3;
	TextEntry unk4;
	TextEntry unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7603);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(TextEntry.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(TextEntry.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(TextEntry.class,obj, 5);
	}
}
