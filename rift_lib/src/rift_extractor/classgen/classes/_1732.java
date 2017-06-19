package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1732 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1732")
public class _1732 
{
	public _1732(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1732);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
