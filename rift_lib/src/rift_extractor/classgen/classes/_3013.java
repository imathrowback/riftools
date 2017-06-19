package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3013 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3013")
public class _3013 
{
	public _3013(){}
	java.lang.Boolean unk0;
	java.lang.Boolean unk1;
	java.lang.String unk2;
	java.lang.Boolean unk3;
	java.lang.String unk4;
	java.lang.Long unk5;
	java.lang.Boolean unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3013);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
	}
}
