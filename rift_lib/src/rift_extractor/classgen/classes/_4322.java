package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4322 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4322")
public class _4322 
{
	public _4322(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.util.List<java.lang.String> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4322);

		unk0 = ClassUtils.list(java.lang.String.class,obj,0);
	}
}
