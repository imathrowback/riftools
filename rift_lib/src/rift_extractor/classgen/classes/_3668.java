package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3668 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3668")
public class _3668 
{
	public _3668(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3668);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
