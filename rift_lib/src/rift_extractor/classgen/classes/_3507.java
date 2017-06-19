package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3507 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3507")
public class _3507 
{
	public _3507(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.List<_3511> unk1;
	java.util.List<_3617> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3507);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.list(_3511.class,obj,1);
		unk2 = ClassUtils.list(_3617.class,obj,2);
	}
}
