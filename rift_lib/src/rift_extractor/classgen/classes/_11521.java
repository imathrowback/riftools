package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11521 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11521")
public class _11521 
{
	public _11521(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11521);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
	}
}
