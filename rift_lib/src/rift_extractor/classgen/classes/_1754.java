package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1754 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1754")
public class _1754 
{
	public _1754(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1754);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
