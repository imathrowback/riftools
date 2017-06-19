package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4005 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4005")
public class _4005 
{
	public _4005(){}
	java.lang.Boolean unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4005);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
	}
}
