package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1627 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1627")
public class _1627 
{
	public _1627(){}
	java.lang.Float unk0;
	java.lang.String unk1;
	java.lang.Long unk2;
	java.lang.Float unk3;
	java.lang.Float unk4;
	java.lang.Boolean unk5;
	java.lang.String unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1627);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
	}
}
