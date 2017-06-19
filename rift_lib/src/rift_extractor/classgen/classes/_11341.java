package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11341 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11341")
public class _11341 
{
	public _11341(){}
	java.util.List<_11342> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11341);

		unk0 = ClassUtils.list(_11342.class,obj,0);
	}
}
