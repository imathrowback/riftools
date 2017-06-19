package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7735 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7735")
public class _7735 
{
	public _7735(){}
	java.lang.String unk0;
	java.lang.Float unk1;
	java.lang.Float unk2;
	rift_extractor.classgen.Vector3 unk3;
	rift_extractor.classgen.Vector3 unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;
	java.lang.Boolean unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7735);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.vector3(obj,3);
		unk4 = ClassUtils.vector3(obj,4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
	}
}
