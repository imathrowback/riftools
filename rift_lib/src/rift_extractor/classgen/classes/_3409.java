package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3409 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3409")
public class _3409 extends _999510
{
	public _3409(){}
	java.util.List<_3408> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3409);

		unk0 = ClassUtils.list(_3408.class,obj,0);
	}
}
