package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1868 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1868")
public class _1868 
{
	public _1868(){}
	public java.lang.Float unk0;
	public java.util.List<java.lang.Long> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1868);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
	}
}
