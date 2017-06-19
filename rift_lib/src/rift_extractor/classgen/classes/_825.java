package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 825 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_825")
public class _825 
{
	public _825(){}
	Object unk0;
	java.lang.Long unk1;
	rift_extractor.classgen.Vector4 unk2;
	java.lang.Long unk3;
	rift_extractor.classgen.Vector4 unk4;
	java.lang.Long unk5;
	rift_extractor.classgen.Vector4 unk6;
	java.lang.Boolean unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 825);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.vector4(obj,2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.vector4(obj,4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.vector4(obj,6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
	}
}
