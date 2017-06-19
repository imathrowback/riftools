package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3404 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3404")
public class _3404 
{
	public _3404(){}
	Object unk0;
	java.util.List<_3403> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3404);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(_3403.class,obj,1);
	}
}
