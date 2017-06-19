package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3610 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3610")
public class _3610 
{
	public _3610(){}
	java.lang.String unk0;
	Object unk1;
	java.util.List<_316> unk2;
	java.util.List<_316> unk3;
	java.lang.String unk4;
	java.lang.String unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3610);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.list(_316.class,obj,2);
		unk3 = ClassUtils.list(_316.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class,obj, 5);
	}
}
