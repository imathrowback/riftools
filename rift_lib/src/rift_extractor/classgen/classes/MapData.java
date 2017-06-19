package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 107 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("MapData")
public class MapData 
{
	public MapData(){}
	public java.util.List<ObjectInstance> instances;
	@com.thoughtworks.xstream.annotations.XStreamOmitField
	public java.lang.String umbraDataBlock;
	Object unk2;
	Object unk3;
	public java.util.List<_108> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 107);

		instances = ClassUtils.list(ObjectInstance.class,obj,0);
		umbraDataBlock = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(_108.class,obj,4);
	}
}
