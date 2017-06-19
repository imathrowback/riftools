package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4275 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4275")
public class _4275 
{
	public _4275(){}
	Object unk0;
	java.lang.Boolean unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4275);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
	}
}
