package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1774 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1774")
public class _1774 
{
	public _1774(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	Object unk7;
	Object unk8;
	Object unk9;
	Object unk10;
	Object unk11;
	Object unk12;
	_1622 unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1774);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(Object.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(Object.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(Object.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(Object.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(_1622.class,obj, 13);
	}
}
