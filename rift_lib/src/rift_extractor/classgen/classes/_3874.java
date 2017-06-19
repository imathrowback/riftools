package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3874 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3874")
public class _3874 
{
	public _3874(){}
	java.util.List<_1864> unk0;
	java.util.List<_1864> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3874);

		unk0 = ClassUtils.list(_1864.class,obj,0);
		unk1 = ClassUtils.list(_1864.class,obj,1);
	}
}
