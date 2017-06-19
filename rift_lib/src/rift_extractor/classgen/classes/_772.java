package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 772 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_772")
public class _772 
{
	public _772(){}
	java.lang.String unk0;
	ID unk1;
	java.util.List<_774> unk2;
	java.util.HashMap<java.lang.Long,_303> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 772);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.list(_774.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
	}
}
