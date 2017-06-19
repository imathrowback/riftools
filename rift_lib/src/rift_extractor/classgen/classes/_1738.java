package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1738 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1738")
public class _1738 extends _999561
{
	public _1738(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	java.util.List<java.lang.Long> unk2;
	java.util.List<java.lang.Long> unk3;
	java.util.List<java.lang.Long> unk4;
	java.util.List<java.lang.Long> unk5;
	java.util.List<java.lang.Long> unk6;
	java.lang.Long unk7;
	java.lang.Long unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1738);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
	}
}
