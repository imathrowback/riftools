package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3594 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3594")
public class _3594 extends _999515
{
	public _3594(){}
	_7501 unk0;
	java.lang.Float unk1;
	java.lang.Float unk2;
	java.lang.Long unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3594);

		unk0 = ClassUtils.getFieldMember(_7501.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
	}
}
