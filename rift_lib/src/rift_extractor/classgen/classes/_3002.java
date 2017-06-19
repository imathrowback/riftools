package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3002 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3002")
public class _3002 
{
	public _3002(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.String unk2;
	java.lang.Boolean unk3;
	java.lang.Float unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3002);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
	}
}
