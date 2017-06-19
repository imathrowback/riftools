package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1890 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1890")
public class _1890 
{
	public _1890(){}
	java.util.List<_4112> unk0;
	Object unk1;
	java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1890);

		unk0 = ClassUtils.list(_4112.class,obj,0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
