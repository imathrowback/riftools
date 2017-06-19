package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1857 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1857")
public class _1857 
{
	public _1857(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.String unk3;
	java.util.List<java.lang.Long> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1857);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
	}
}
