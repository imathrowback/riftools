package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10889 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10889")
public class _10889 
{
	public _10889(){}
	java.lang.Float unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10889);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
