package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6004 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6004")
public class _6004 
{
	public _6004(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6004);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
