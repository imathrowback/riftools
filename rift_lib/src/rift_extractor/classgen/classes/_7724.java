package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7724 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7724")
public class _7724 
{
	public _7724(){}
	java.util.List<_4112> unk0;
	java.util.List<_4114> unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;
	java.lang.Long unk4;
	_1852 unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7724);

		unk0 = ClassUtils.list(_4112.class,obj,0);
		unk1 = ClassUtils.list(_4114.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(_1852.class,obj, 5);
	}
}
