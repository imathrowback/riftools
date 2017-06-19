package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1707 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1707")
public class _1707 extends _999558
{
	public _1707(){}
	Object unk0;
	java.lang.Long unk1;
	Object unk2;
	Object unk3;
	java.lang.Float unk4;
	java.lang.Boolean unk5;
	java.lang.Long unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1707);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
	}
}
