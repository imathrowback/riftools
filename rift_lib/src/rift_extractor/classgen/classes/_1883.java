package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1883 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1883")
public class _1883 
{
	public _1883(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	Object unk2;
	Object unk3;
	_1622 unk4;
	Object unk5;
	_3825 unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1883);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(_1622.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(_3825.class,obj, 6);
	}
}
