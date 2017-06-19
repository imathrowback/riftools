package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1624 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1624")
public class _1624 extends _999559
{
	public _1624(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1624);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
