package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1799 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1799")
public class _1799 
{
	public _1799(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1799);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
