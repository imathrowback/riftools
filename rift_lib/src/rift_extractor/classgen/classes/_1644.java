package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1644 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1644")
public class _1644 
{
	public _1644(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Boolean unk5;
	java.lang.Float unk6;
	rift_extractor.classgen.Vector4 unk7;
	java.lang.Boolean unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1644);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.vector4(obj,7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
	}
}
