package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1891 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1891")
public class _1891 extends _999542
{
	public _1891(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1891);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
