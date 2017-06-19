package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3001 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3001")
public class _3001 
{
	public _3001(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	java.lang.Long unk2;
	java.util.List<_3000> unk3;
	java.lang.Float unk4;
	java.lang.Float unk5;
	java.lang.Boolean unk6;
	java.lang.Float unk7;
	java.lang.Long unk8;
	java.lang.Boolean unk9;
	java.util.List<java.lang.Long> unk10;
	Object unk11;
	java.lang.Long unk12;
	java.util.List<_1622> unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3001);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.list(_3000.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.list(java.lang.Long.class,obj,10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.list(_1622.class,obj,13);
	}
}
