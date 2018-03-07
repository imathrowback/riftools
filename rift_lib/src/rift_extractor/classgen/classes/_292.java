package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 292 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_292")
public class _292 
{
	public _292(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	java.lang.Boolean unk2;
	java.util.List<java.lang.String> unk3;
	TextEntry unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;
	java.lang.Long unk7;
	_314 unk8;
	java.lang.Boolean unk9;
	java.lang.Long unk10;
	_314 unk11;
	_314 unk12;
	_314 unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 292);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.list(java.lang.String.class,obj,3);
		unk4 = ClassUtils.getFieldMember(TextEntry.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(_314.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(_314.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(_314.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(_314.class,obj, 13);
	}
}
