package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3884 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3884")
public class _3884 
{
	public _3884(){}
	Object unk0;
	java.util.List<_3887> unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;
	java.util.List<_3919> unk4;
	java.lang.Boolean unk5;
	java.lang.Boolean unk6;
	java.lang.Boolean unk7;
	java.lang.Boolean unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3884);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(_3887.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.list(_3919.class,obj,4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
	}
}
