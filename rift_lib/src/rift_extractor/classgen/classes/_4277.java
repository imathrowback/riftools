package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4277 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4277")
public class _4277 
{
	public _4277(){}
	java.util.List<_4282> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4277);

		unk0 = ClassUtils.list(_4282.class,obj,0);
	}
}
