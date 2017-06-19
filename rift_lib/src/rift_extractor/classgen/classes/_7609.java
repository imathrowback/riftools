package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7609 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7609")
public class _7609 
{
	public _7609(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	java.lang.Long unk2;
	ID unk3;
	java.util.List<_6016> unk4;
	java.lang.Boolean unk5;
	java.lang.String unk6;
	Object unk7;
	java.lang.Long unk8;
	java.lang.Long unk9;
	java.util.List<_6026> unk10;
	java.util.List<java.lang.Long> unk11;
	java.lang.Long unk12;
	java.lang.Long unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7609);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
		unk4 = ClassUtils.list(_6016.class,obj,4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
		unk10 = ClassUtils.list(_6026.class,obj,10);
		unk11 = ClassUtils.list(java.lang.Long.class,obj,11);
		unk12 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 13);
	}
}
