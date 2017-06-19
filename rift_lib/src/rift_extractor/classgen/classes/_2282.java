package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2282 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2282")
public class _2282 
{
	public _2282(){}
	java.lang.Boolean unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2282);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
	}
}
