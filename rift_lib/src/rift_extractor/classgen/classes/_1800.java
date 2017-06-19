package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1800 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1800")
public class _1800 
{
	public _1800(){}
	java.lang.Boolean unk0;
	java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1800);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
