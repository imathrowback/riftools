package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1673 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1673")
public class _1673 extends _999599
{
	public _1673(){}
	Object unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	java.lang.Boolean unk6;
	java.lang.Long unk7;
	java.lang.Float unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1673);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
	}
}
