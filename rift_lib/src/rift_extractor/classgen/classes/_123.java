package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 123 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_123")
public class _123 
{
	public _123(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	_10003 unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 123);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(_10003.class,obj, 2);
	}
}
