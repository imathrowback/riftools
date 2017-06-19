package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3545 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3545")
public class _3545 extends _999501
{
	public _3545(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3545);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
