package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 287 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_287")
public class _287 
{
	public _287(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.Long unk2;
	TextEntry unk3;
	java.lang.String unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 287);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(TextEntry.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
	}
}
