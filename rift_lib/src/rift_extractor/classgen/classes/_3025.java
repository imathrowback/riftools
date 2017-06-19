package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3025 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3025")
public class _3025 
{
	public _3025(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Float unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Float unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3025);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
	}
}
