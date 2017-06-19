package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3598 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3598")
public class _3598 
{
	public _3598(){}
	java.lang.String unk0;
	ID unk1;
	java.util.List<_3507> unk2;
	Object unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	Object unk7;
	java.util.List<_3608> unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3598);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.list(_3507.class,obj,2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.list(_3608.class,obj,8);
	}
}
