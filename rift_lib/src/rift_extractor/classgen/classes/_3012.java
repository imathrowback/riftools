package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3012 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3012")
public class _3012 extends _999507
{
	public _3012(){}
	java.lang.String unk0;
	java.lang.String unk1;
	Object unk2;
	Object unk3;
	java.lang.Boolean unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3012);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
	}
}
