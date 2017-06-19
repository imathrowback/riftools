package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3869 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3869")
public class _3869 
{
	public _3869(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3869);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
