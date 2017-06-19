package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10896 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10896")
public class _10896 extends _999500
{
	public _10896(){}
	Object unk0;
	java.util.List<java.lang.Long> unk1;
	Object unk2;
	Object unk3;
	java.lang.Boolean unk4;
	java.util.List<java.lang.Long> unk5;
	java.lang.Boolean unk6;
	java.util.List<java.lang.Long> unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10896);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
	}
}
