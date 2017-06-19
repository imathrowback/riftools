package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 248 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_248")
public class _248 
{
	public _248(){}
	java.util.List<_224> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 248);

		unk0 = ClassUtils.list(_224.class,obj,0);
	}
}
