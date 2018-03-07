package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 151 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_151")
public class _151 
{
	public _151(){}
	TextEntry unk0;
	java.lang.String unk1;
	java.lang.String unk2;
	java.lang.String unk3;
	java.lang.String unk4;
	java.lang.Long unk5;
	java.lang.Boolean unk6;
	java.util.List<java.lang.Long> unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 151);

		unk0 = ClassUtils.getFieldMember(TextEntry.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.list(java.lang.Long.class,obj,7);
	}
}
