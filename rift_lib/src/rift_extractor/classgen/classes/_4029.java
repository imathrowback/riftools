package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4029 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4029")
public class _4029 extends _999536
{
	public _4029(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4029);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
