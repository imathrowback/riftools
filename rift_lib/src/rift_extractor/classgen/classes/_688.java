package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 688 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_688")
public class _688 
{
	public _688(){}
	Object unk0;
	Object unk1;
	java.util.HashMap<java.lang.Long,_233> unk2;
	java.util.List<_3600> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 688);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
		unk3 = ClassUtils.list(_3600.class,obj,3);
	}
}
