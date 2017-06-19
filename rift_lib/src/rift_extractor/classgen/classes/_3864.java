package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3864 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3864")
public class _3864 
{
	public _3864(){}
	java.lang.Boolean unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	Object unk3;
	java.lang.Long unk4;
	_3525 unk5;
	_3525 unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3864);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(_3525.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(_3525.class,obj, 6);
	}
}
