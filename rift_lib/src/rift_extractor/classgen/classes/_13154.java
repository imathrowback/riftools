package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13154 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13154")
public class _13154 
{
	public _13154(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	java.lang.Boolean unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;
	java.lang.Double unk7;
	java.lang.Double unk8;
	java.util.List<java.lang.Long> unk9;
	_13189 unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13154);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 8);
		unk9 = ClassUtils.list(java.lang.Long.class,obj,9);
		unk10 = ClassUtils.getFieldMember(_13189.class,obj, 10);
	}
}
