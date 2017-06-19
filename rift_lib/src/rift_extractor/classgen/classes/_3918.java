package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3918 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3918")
public class _3918 
{
	public _3918(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.String unk0;
	public java.util.List<java.lang.Long> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3918);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
	}
}
