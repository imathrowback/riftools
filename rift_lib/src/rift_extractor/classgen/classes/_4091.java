package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4091 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4091")
public class _4091 
{
	public _4091(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	java.util.List<java.lang.Long> unk6;
	java.util.List<java.lang.Long> unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4091);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
	}
}
