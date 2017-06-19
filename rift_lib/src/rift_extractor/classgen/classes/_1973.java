package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1973 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1973")
public class _1973 
{
	public _1973(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1973);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
