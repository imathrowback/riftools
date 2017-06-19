package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3718 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3718")
public class _3718 
{
	public _3718(){}
	Object unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	java.util.List<java.lang.Long> unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3718);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
	}
}
