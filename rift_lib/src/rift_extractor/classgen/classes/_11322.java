package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11322 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11322")
public class _11322 extends _999542
{
	public _11322(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11322);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
