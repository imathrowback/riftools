package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7722 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7722")
public class _7722 extends _999548
{
	public _7722(){}
	java.lang.Float unk0;
	java.lang.Boolean unk1;
	java.util.List<_4112> unk2;
	java.util.List<_4114> unk3;
	_1852 unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7722);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
		unk2 = ClassUtils.list(_4112.class,obj,2);
		unk3 = ClassUtils.list(_4114.class,obj,3);
		unk4 = ClassUtils.getFieldMember(_1852.class,obj, 4);
	}
}
