package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1975 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1975")
public class _1975 
{
	public _1975(){}
	java.lang.String unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	java.lang.Long unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1975);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
	}
}
