package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3403 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3403")
public class _3403 
{
	public _3403(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.List<_3402> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3403);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.list(_3402.class,obj,1);
	}
}
