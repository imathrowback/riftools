package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3226 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3226")
public class _3226 
{
	public _3226(){}
	java.lang.String unk0;
	java.lang.String unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3226);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
	}
}
