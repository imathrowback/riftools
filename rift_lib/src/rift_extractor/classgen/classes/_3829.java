package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3829 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3829")
public class _3829 extends _999536
{
	public _3829(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3829);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
