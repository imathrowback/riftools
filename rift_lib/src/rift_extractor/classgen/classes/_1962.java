package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1962 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1962")
public class _1962 
{
	public _1962(){}
	Object unk0;
	java.util.List<_699> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1962);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(_699.class,obj,1);
	}
}
