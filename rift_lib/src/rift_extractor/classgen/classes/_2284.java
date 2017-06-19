package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2284 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2284")
public class _2284 
{
	public _2284(){}
	java.lang.Boolean unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2284);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
	}
}
