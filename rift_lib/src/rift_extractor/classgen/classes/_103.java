package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 103 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_103")
public class _103 
{
	public _103(){}
	TextEntry unk0;
	java.lang.Long unk1;
	java.lang.Float unk2;
	java.lang.Float unk3;
	java.lang.String unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 103);

		unk0 = ClassUtils.getFieldMember(TextEntry.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
	}
}
