package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3039 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3039")
public class _3039 
{
	public _3039(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3039);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
