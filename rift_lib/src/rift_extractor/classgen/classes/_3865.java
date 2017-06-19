package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3865 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3865")
public class _3865 
{
	public _3865(){}
	java.lang.Float unk0;
	Object unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	Object unk4;
	_3525 unk5;
	_3525 unk6;
	_3525 unk7;
	_3525 unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3865);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(_3525.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(_3525.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(_3525.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(_3525.class,obj, 8);
	}
}
