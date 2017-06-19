package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3567 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3567")
public class _3567 
{
	public _3567(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3567);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
