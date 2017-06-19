package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4016 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4016")
public class _4016 
{
	public _4016(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4016);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
