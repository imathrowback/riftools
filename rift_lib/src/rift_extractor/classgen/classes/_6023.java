package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6023 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6023")
public class _6023 
{
	public _6023(){}
	java.util.List<_6024> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6023);

		unk0 = ClassUtils.list(_6024.class,obj,0);
	}
}
