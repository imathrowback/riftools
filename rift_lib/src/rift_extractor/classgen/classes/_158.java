package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 158 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_158")
public class _158 
{
	public _158(){}
	java.util.List<_155> unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 158);

		unk0 = ClassUtils.list(_155.class,obj,0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
	}
}
