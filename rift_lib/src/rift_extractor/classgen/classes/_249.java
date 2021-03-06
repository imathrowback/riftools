package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 249 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_249")
public class _249 
{
	public _249(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	TextEntry unk2;
	TextEntry unk3;
	java.util.List<java.lang.Long> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 249);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(TextEntry.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
	}
}
