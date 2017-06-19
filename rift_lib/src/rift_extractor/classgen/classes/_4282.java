package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4282 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4282")
public class _4282 
{
	public _4282(){}
	java.lang.String unk0;
	java.util.List<_999517> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4282);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_999517.class,obj,1);
	}
}
