package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3208 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3208")
public class _3208 
{
	public _3208(){}
	java.lang.String unk0;
	java.util.HashMap<java.lang.Long,_3207> unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3208);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
	}
}
