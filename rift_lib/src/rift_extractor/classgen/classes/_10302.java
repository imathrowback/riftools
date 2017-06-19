package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10302 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10302")
public class _10302 
{
	public _10302(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	java.util.List<_10301> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10302);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.list(_10301.class,obj,1);
	}
}
