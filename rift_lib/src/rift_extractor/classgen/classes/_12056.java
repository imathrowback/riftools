package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 12056 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_12056")
public class _12056 
{
	public _12056(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	Object unk2;
	java.lang.Float unk3;
	java.lang.Boolean unk4;
	java.util.List<_999504> unk5;
	java.lang.Boolean unk6;
	java.lang.Long unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 12056);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.list(_999504.class,obj,5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
	}
}
