package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3230 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3230")
public class _3230 
{
	public _3230(){}
	public java.lang.Float unk0;
	public java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3230);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
