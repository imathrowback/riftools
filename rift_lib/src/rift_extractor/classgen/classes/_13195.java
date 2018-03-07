package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13195 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13195")
public class _13195 
{
	public _13195(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	TextEntry unk2;
	Object unk3;
	Object unk4;
	java.util.List<java.lang.String> unk5;
	Object unk6;
	java.lang.Long unk7;
	java.lang.Float unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13195);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.String.class,obj,5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
	}
}
