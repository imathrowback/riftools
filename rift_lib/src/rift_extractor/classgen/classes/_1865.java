package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1865 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1865")
public class _1865 
{
	public _1865(){}
	public _313 unk0;
	public java.lang.Long unk1;
	public java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1865);

		unk0 = ClassUtils.getFieldMember(_313.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
