package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4094 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4094")
public class _4094 
{
	public _4094(){}
	java.lang.Boolean unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4094);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
	}
}
