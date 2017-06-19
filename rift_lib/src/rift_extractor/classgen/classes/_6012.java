package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6012 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6012")
public class _6012 
{
	public _6012(){}
	java.lang.String unk0;
	java.lang.String unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6012);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
	}
}
