package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10868 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10868")
public class _10868 
{
	public _10868(){}
	java.lang.String unk0;
	java.lang.Float unk1;
	java.lang.Long unk2;
	java.lang.Float unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;
	java.lang.Float unk7;
	java.lang.Long unk8;
	java.lang.Boolean unk9;
	java.lang.Float unk10;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10868);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 10);
	}
}
