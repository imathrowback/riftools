package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3979 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3979")
public class _3979 extends _999539
{
	public _3979(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3979);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
