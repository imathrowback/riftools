package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4628 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4628")
public class _4628 
{
	public _4628(){}
	java.lang.String unk0;
	java.util.List<_3507> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4628);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_3507.class,obj,1);
	}
}
