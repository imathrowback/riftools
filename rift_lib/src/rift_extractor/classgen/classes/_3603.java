package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3603 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3603")
public class _3603 
{
	public _3603(){}
	java.util.List<_3604> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3603);

		unk0 = ClassUtils.list(_3604.class,obj,0);
	}
}
