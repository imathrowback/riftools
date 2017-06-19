package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6019 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6019")
public class _6019 
{
	public _6019(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6019);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
