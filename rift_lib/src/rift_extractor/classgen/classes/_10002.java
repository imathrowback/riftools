package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10002 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10002")
public class _10002 
{
	public _10002(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Boolean unk1;
	java.lang.String unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10002);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
	}
}
