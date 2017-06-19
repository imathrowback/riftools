package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3842 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3842")
public class _3842 
{
	public _3842(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	java.lang.Float unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;
	java.lang.Float unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3842);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
	}
}
