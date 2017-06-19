package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1543 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1543")
public class _1543 
{
	public _1543(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.util.List<java.lang.Long> unk0;
	Object unk1;
	Object unk2;
	public java.util.List<java.lang.Long> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1543);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
	}
}
