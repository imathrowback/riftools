package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2207 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2207")
public class _2207 
{
	public _2207(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Float unk4;
	java.lang.Boolean unk5;
	java.lang.Boolean unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2207);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
	}
}
