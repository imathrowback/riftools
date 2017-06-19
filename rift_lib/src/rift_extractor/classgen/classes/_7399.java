package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7399 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7399")
public class _7399 
{
	public _7399(){}
	java.lang.Float unk0;
	rift_extractor.classgen.Vector3 unk1;
	rift_extractor.classgen.Vector3 unk2;
	rift_extractor.classgen.Vector3 unk3;
	java.lang.Float unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7399);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.vector3(obj,1);
		unk2 = ClassUtils.vector3(obj,2);
		unk3 = ClassUtils.vector3(obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
	}
}
