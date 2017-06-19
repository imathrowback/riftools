package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10883 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10883")
public class _10883 extends _999500
{
	public _10883(){}
	java.lang.Boolean unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Boolean unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10883);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
	}
}
