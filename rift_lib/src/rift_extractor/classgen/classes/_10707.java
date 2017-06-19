package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10707 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10707")
public class _10707 
{
	public _10707(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10707);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
