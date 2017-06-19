package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1873 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1873")
public class _1873 
{
	public _1873(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1873);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
