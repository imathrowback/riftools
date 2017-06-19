package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7731 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7731")
public class _7731 
{
	public _7731(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.Float unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7731);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
	}
}
