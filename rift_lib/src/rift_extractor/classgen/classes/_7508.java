package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7508 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7508")
public class _7508 
{
	public _7508(){}
	java.lang.String unk0;
	Object unk1;
	java.util.HashMap<java.lang.Long,_303> unk2;
	java.util.HashMap<java.lang.Long,_307> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7508);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
	}
}
