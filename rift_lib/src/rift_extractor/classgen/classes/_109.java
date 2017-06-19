package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 109 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_109")
public class _109 
{
	public _109(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long refTo113;
	public java.lang.Long unk1;
	public rift_extractor.classgen.Vector3 unk2;
	public java.util.List<_305> unk3;
	public java.lang.Long unk4;
	public java.util.List<_127> unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 109);

		refTo113 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.vector3(obj,2);
		unk3 = ClassUtils.list(_305.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.list(_127.class,obj,5);
	}
}
