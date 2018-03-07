package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8277 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8277")
public class _8277 
{
	public _8277(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.String unk2;
	java.lang.String unk3;
	java.lang.String unk4;
	java.lang.Long unk5;
	Object unk6;
	java.lang.Boolean unk7;
	Object unk8;
	TextEntry unk9;
	java.util.HashMap<java.lang.Long,_304> unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8277);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(Object.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(TextEntry.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 10);
	}
}
