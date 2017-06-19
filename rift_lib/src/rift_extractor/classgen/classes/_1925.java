package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1925 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1925")
public class _1925 extends _999541
{
	public _1925(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1925);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
