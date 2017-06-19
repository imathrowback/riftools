package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1121 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1121")
public class _1121 
{
	public _1121(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	public java.util.List<java.lang.Long> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1121);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
	}
}
