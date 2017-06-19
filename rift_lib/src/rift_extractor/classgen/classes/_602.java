package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 602 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_602")
public class _602 extends _999500
{
	public _602(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	Object unk1;
	Object unk2;
	public rift_extractor.classgen.Vector3 unk3;
	public java.lang.Integer unk4;
	public java.lang.Integer unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 602);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.vector3(obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Integer.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Integer.class,obj, 5);
	}
}
