package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3825 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3825")
public class _3825 
{
	public _3825(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	Object unk1;
	Object unk2;
	java.util.List<java.lang.Long> unk3;
	java.util.List<java.lang.Long> unk4;
	java.util.List<java.lang.Long> unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3825);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.Long.class,obj,3);
		unk4 = ClassUtils.list(java.lang.Long.class,obj,4);
		unk5 = ClassUtils.list(java.lang.Long.class,obj,5);
	}
}
