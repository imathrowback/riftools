package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3844 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3844")
public class _3844 extends _999501
{
	public _3844(){}
	java.util.List<_999501> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3844);

		unk0 = ClassUtils.list(_999501.class,obj,0);
	}
}
