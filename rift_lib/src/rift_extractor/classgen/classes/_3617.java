package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3617 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3617")
public class _3617 
{
	public _3617(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3617);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
