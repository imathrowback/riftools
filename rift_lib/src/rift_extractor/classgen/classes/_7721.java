package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7721 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7721")
public class _7721 
{
	public _7721(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	Object unk3;
	Object unk4;
	java.util.List<_4112> unk5;
	java.util.List<_4114> unk6;
	_1852 unk7;
	java.lang.Boolean unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7721);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.list(_4112.class,obj,5);
		unk6 = ClassUtils.list(_4114.class,obj,6);
		unk7 = ClassUtils.getFieldMember(_1852.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 8);
	}
}
