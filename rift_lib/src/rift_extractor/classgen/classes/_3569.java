package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3569 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3569")
public class _3569 
{
	public _3569(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3569);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
