package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 603 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("MapObjectTransform")
public class MapObjectTransform extends _999500
{
	public MapObjectTransform(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long modelReference;
	Object unk1;
	Object unk2;
	public rift_extractor.classgen.Vector3 position;
	public rift_extractor.classgen.Vector4 rotation;
	public java.lang.Float scale;
	Object unk6;
	Object unk7;
	Object unk8;
	public rift_extractor.classgen.Vector3 position2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 603);

		modelReference = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		position = ClassUtils.vector3(obj,3);
		rotation = ClassUtils.vector4(obj,4);
		scale = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		position2 = ClassUtils.vector3(obj,9);
	}
}
