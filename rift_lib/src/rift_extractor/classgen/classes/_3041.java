package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3041 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3041")
public class _3041 
{
	public _3041(){}
	java.lang.String unk0;
	java.lang.Float unk1;
	Object unk2;
	rift_extractor.classgen.Vector4 unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3041);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.vector4(obj,3);
	}
}
