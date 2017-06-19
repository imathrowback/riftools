package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 250 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_250")
public class _250 
{
	public _250(){}
	java.lang.String unk0;
	java.lang.Float unk1;
	java.lang.String unk2;
	java.util.List<java.lang.Long> unk3;
	java.lang.String unk4;
	java.lang.Boolean unk5;
	java.lang.Long unk6;
	java.lang.String unk7;
	java.lang.String unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 250);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.String.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.String.class,obj, 8);
	}
}
