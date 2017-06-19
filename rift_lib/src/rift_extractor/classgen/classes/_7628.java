package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7628 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7628")
public class _7628 
{
	public _7628(){}
	java.lang.String unk0;
	ID unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.util.List<java.lang.Long> unk5;
	java.lang.Long unk6;
	java.lang.Boolean unk7;
	java.lang.Float unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7628);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
	}
}
