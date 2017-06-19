package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4655 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4655")
public class _4655 
{
	public _4655(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4655);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
