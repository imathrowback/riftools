package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3834 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3834")
public class _3834 extends _999536
{
	public _3834(){}
	java.util.List<_999501> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3834);

		unk0 = ClassUtils.list(_999501.class,obj,0);
	}
}
