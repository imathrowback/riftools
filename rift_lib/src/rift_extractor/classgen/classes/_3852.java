package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3852 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3852")
public class _3852 
{
	public _3852(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3852);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
