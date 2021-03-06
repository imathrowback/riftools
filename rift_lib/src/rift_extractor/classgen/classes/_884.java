package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 884 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_884")
public class _884 
{
	public _884(){}
	java.lang.String unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	java.util.List<java.lang.Long> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 884);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
	}
}
