package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 600 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("ObjectInstance")
public class ObjectInstance 
{
	public ObjectInstance(){}
	public java.lang.Double id;
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.String name;
	Object unk2;
	Object unk3;
	public java.util.List<_999500> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 600);

		id = ClassUtils.getFieldMember(java.lang.Double.class,obj, 0);
		name = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(_999500.class,obj,4);
	}
}
