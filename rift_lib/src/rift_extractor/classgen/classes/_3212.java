package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3212 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3212")
public class _3212 
{
	public _3212(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Boolean unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3212);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
	}
}
