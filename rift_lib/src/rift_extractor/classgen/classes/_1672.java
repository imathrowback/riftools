package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1672 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1672")
public class _1672 extends _999571
{
	public _1672(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	java.util.List<java.lang.Long> unk1;
	Object unk2;
	Object unk3;
	java.util.List<java.lang.Long> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1672);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
	}
}
