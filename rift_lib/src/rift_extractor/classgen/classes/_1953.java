package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1953 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1953")
public class _1953 
{
	public _1953(){}
	java.util.List<_4112> unk0;
	java.util.List<_4114> unk1;
	java.lang.Long unk2;
	_1852 unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1953);

		unk0 = ClassUtils.list(_4112.class,obj,0);
		unk1 = ClassUtils.list(_4114.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(_1852.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
	}
}
