package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 102 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_102")
public class _102 
{
	public _102(){}
	Object unk0;
	public java.lang.Long unk1;
	public java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 102);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
