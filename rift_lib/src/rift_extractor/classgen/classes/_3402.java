package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3402 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3402")
public class _3402 extends _999509
{
	public _3402(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3402);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
