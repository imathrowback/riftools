package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7400 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7400")
public class _7400 
{
	public _7400(){}
	java.util.List<_7398> unk0;
	java.util.List<java.lang.Long> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7400);

		unk0 = ClassUtils.list(_7398.class,obj,0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
	}
}
