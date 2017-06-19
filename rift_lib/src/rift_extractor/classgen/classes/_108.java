package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 108 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_108")
public class _108 
{
	public _108(){}
	public java.lang.Float unk0;
	public java.lang.Double unk1;
	public java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 108);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
