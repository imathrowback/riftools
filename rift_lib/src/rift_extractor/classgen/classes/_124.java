package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 124 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_124")
public class _124 
{
	public _124(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long refTo125;
	public java.lang.Long unk1;
	public rift_extractor.classgen.Vector3 unk2;
	public java.util.List<_305> unk3;
	Object unk4;
	public java.lang.Float unk5;
	public java.util.List<_127> unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 124);

		refTo125 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.vector3(obj,2);
		unk3 = ClassUtils.list(_305.class,obj,3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.list(_127.class,obj,6);
	}
}
