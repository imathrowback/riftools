package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1706 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1706")
public class _1706 extends _999539
{
	public _1706(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1706);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
