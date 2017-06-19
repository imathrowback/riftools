package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4022 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4022")
public class _4022 extends _999568
{
	public _4022(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	Object unk1;
	java.util.List<java.lang.Long> unk2;
	Object unk3;
	java.util.List<java.lang.Long> unk4;
	Object unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4022);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
	}
}
