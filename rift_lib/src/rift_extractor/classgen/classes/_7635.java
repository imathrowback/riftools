package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7635 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7635")
public class _7635 
{
	public _7635(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	java.util.List<_304> unk1;
	java.util.List<java.lang.Long> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7635);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.list(_304.class,obj,1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
	}
}
