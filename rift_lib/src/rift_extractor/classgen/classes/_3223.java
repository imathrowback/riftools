package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3223 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3223")
public class _3223 
{
	public _3223(){}
	java.util.List<_3222> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3223);

		unk0 = ClassUtils.list(_3222.class,obj,0);
	}
}
