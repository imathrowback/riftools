package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11323 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11323")
public class _11323 
{
	public _11323(){}
	Object unk0;
	java.util.List<_11335> unk1;
	java.util.List<_11336> unk2;
	java.util.List<_11523> unk3;
	java.lang.Boolean unk4;
	java.lang.Boolean unk5;
	java.lang.Long unk6;
	java.lang.Boolean unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11323);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(_11335.class,obj,1);
		unk2 = ClassUtils.list(_11336.class,obj,2);
		unk3 = ClassUtils.list(_11523.class,obj,3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
	}
}
