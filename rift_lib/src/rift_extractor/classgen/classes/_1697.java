package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1697 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1697")
public class _1697 
{
	public _1697(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	Object unk7;
	java.lang.Boolean unk8;
	java.lang.Long unk9;
	java.lang.Boolean unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1697);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 10);
	}
}
