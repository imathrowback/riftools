package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3011 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3011")
public class _3011 
{
	public _3011(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3011);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
