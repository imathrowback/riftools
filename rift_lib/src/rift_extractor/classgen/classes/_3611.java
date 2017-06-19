package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3611 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3611")
public class _3611 
{
	public _3611(){}
	java.lang.String unk0;
	ID unk1;
	java.lang.Boolean unk2;
	java.util.List<_3507> unk3;
	java.lang.Boolean unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3611);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.list(_3507.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
	}
}
