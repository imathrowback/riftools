package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1606 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1606")
public class _1606 extends _999552
{
	public _1606(){}
	Object unk0;
	Object unk1;
	Object unk2;
	java.lang.Boolean unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1606);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
	}
}
