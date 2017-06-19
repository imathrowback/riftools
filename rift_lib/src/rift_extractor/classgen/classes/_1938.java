package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1938 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1938")
public class _1938 
{
	public _1938(){}
	public java.lang.Boolean unk0;
	public java.lang.Long unk1;
	Object unk2;
	public java.lang.Long unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1938);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
	}
}
