package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3210 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3210")
public class _3210 
{
	public _3210(){}
	java.lang.Boolean unk0;
	java.lang.String unk1;
	java.util.HashMap<java.lang.Long,_3221> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3210);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
	}
}
