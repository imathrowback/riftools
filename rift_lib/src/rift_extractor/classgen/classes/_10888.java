package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10888 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10888")
public class _10888 
{
	public _10888(){}
	java.lang.String unk0;
	Object unk1;
	Object unk2;
	java.util.List<_10889> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10888);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.list(_10889.class,obj,3);
	}
}
