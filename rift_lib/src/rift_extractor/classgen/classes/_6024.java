package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6024 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6024")
public class _6024 
{
	public _6024(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6024);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
