package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 122 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_122")
public class _122 
{
	public _122(){}
	java.lang.String unk0;
	_117 unk1;
	java.lang.Boolean unk2;
	_10003 unk3;
	java.lang.Float unk4;
	java.lang.Long unk5;
	java.lang.String unk6;
	java.lang.Float unk7;
	_1894 unk8;
	java.lang.Long unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 122);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(_117.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(_10003.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(_1894.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
	}
}
