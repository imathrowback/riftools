package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3215 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3215")
public class _3215 
{
	public _3215(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Float unk5;
	ID unk6;
	ID unk7;
	ID unk8;
	ID unk9;
	ID unk10;
	java.lang.String unk11;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3215);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(ID.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(ID.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(ID.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(ID.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(ID.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.lang.String.class,obj, 11);
	}
}
