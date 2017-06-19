package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3691 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3691")
public class _3691 
{
	public _3691(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	ID unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3691);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
	}
}
