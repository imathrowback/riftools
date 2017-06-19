package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1882 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1882")
public class _1882 
{
	public _1882(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	_1622 unk6;
	_3826 unk7;
	_3825 unk8;
	java.lang.Boolean unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1882);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(_1622.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(_3826.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(_3825.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
	}
}
