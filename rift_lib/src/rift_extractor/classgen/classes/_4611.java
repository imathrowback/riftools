package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4611 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4611")
public class _4611 
{
	public _4611(){}
	Object unk0;
	java.util.List<_4613> unk1;
	Object unk2;
	java.lang.String unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4611);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(_4613.class,obj,1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
	}
}
