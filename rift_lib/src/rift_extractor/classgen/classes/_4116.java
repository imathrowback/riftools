package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4116 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4116")
public class _4116 
{
	public _4116(){}
	Object unk0;
	Object unk1;
	public java.lang.Float unk2;
	public java.lang.Float unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4116);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
	}
}
