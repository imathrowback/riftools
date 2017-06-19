package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13149 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13149")
public class _13149 
{
	public _13149(){}
	_3600 unk0;
	Object unk1;
	Object unk2;
	java.lang.Boolean unk3;
	ID unk4;
	ID unk5;
	Object unk6;
	java.lang.String unk7;
	Object unk8;
	Object unk9;
	java.lang.Boolean unk10;
	Object unk11;
	Object unk12;
	java.lang.String unk13;
	java.lang.Long unk14;
	java.util.List<java.lang.Long> unk15;
	java.util.List<_8275> unk16;
	java.lang.Boolean unk17;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13149);

		unk0 = ClassUtils.getFieldMember(_3600.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(ID.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(ID.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.String.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(Object.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.String.class,obj, 13);
		unk14 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 14);
		unk15 = ClassUtils.list(java.lang.Long.class,obj,15);
		unk16 = ClassUtils.list(_8275.class,obj,16);
		unk17 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 17);
	}
}
