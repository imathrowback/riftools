package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1783 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1783")
public class _1783 extends _999579
{
	public _1783(){}
	java.lang.Float unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	java.lang.Long unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1783);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
	}
}
