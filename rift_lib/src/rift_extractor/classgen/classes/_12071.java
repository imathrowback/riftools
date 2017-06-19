package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 12071 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_12071")
public class _12071 
{
	public _12071(){}
	java.util.List<_12064> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 12071);

		unk0 = ClassUtils.list(_12064.class,obj,0);
	}
}
