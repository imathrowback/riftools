package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7725 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7725")
public class _7725 extends _999548
{
	public _7725(){}
	java.util.List<_4112> unk0;
	java.util.List<_4114> unk1;
	_1852 unk2;
	java.lang.Float unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7725);

		unk0 = ClassUtils.list(_4112.class,obj,0);
		unk1 = ClassUtils.list(_4114.class,obj,1);
		unk2 = ClassUtils.getFieldMember(_1852.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
	}
}
