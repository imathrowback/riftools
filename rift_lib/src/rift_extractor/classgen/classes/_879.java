package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 879 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_879")
public class _879 
{
	public _879(){}
	java.lang.String unk0;
	Object unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;
	java.util.List<java.lang.Long> unk4;
	java.lang.Float unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 879);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
	}
}
