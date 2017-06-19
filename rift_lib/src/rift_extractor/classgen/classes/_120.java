package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 120 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_120")
public class _120 
{
	public _120(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long refTo121;
	public rift_extractor.classgen.Vector3 unk1;
	public java.lang.Float unk2;
	public java.lang.Float unk3;
	public java.util.List<_305> unk4;
	public java.util.List<_127> unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 120);

		refTo121 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.vector3(obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.list(_305.class,obj,4);
		unk5 = ClassUtils.list(_127.class,obj,5);
	}
}
