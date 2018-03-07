package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7639 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7639")
public class _7639 
{
	public _7639(){}
	java.lang.String unk0;
	java.lang.Double unk1;
	java.lang.Double unk2;
	java.lang.Double unk3;
	Object unk4;
	java.lang.Long unk5;
	java.lang.String unk6;
	TextEntry unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7639);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(TextEntry.class,obj, 7);
	}
}
