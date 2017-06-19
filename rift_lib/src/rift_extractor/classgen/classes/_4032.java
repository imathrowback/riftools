package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4032 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4032")
public class _4032 
{
	public _4032(){}
	Object unk0;
	java.lang.Long unk1;
	java.util.HashMap<java.lang.Long,_4033> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4032);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
	}
}
