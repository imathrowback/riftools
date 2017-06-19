package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4264 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4264")
public class _4264 
{
	public _4264(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.util.HashMap<java.lang.Long,_4270> unk4;
	java.lang.String unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4264);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class,obj, 5);
	}
}
