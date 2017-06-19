package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2527 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2527")
public class _2527 
{
	public _2527(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2527);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
