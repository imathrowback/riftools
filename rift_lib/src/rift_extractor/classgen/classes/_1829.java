package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1829 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1829")
public class _1829 
{
	public _1829(){}
	java.util.List<_1830> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1829);

		unk0 = ClassUtils.list(_1830.class,obj,0);
	}
}
