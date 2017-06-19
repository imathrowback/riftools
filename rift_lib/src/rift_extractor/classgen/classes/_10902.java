package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10902 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10902")
public class _10902 
{
	public _10902(){}
	java.lang.String unk0;
	java.util.List<java.lang.Long> unk1;
	java.util.List<java.lang.Long> unk2;
	java.util.List<java.lang.String> unk3;
	java.util.List<java.lang.String> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10902);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.list(java.lang.String.class,obj,3);
		unk4 = ClassUtils.list(java.lang.String.class,obj,4);
	}
}
