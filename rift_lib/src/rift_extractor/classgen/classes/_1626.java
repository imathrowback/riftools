package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1626 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1626")
public class _1626 extends _999599
{
	public _1626(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1626);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
	}
}
