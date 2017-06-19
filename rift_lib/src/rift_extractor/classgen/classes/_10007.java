package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10007 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10007")
public class _10007 
{
	public _10007(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.util.HashMap<java.lang.Long,_306> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10007);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
	}
}
