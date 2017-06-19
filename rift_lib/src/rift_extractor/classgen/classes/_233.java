package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 233 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_233")
public class _233 
{
	public _233(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 233);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
