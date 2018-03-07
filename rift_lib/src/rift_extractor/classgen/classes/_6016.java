package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6016 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6016")
public class _6016 
{
	public _6016(){}
	TextEntry unk0;
	java.lang.String unk1;
	java.lang.Long unk2;
	java.lang.Float unk3;
	Object unk4;
	java.lang.Long unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6016);

		unk0 = ClassUtils.getFieldMember(TextEntry.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
	}
}
