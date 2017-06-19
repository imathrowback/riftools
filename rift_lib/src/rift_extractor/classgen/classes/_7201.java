package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7201 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7201")
public class _7201 
{
	public _7201(){}
	Object unk0;
	java.lang.Long unk1;
	java.lang.Boolean unk2;
	java.lang.Float unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7201);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
	}
}
