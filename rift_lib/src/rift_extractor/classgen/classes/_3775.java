package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3775 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3775")
public class _3775 
{
	public _3775(){}
	java.util.List<_3776> unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3775);

		unk0 = ClassUtils.list(_3776.class,obj,0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
