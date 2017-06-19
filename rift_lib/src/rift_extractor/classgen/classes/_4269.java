package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4269 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4269")
public class _4269 
{
	public _4269(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4269);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
