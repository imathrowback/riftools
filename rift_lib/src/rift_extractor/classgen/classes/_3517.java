package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3517 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3517")
public class _3517 
{
	public _3517(){}
	java.lang.String unk0;
	java.util.List<_3507> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3517);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_3507.class,obj,1);
	}
}
