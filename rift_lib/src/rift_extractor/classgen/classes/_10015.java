package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10015 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10015")
public class _10015 
{
	public _10015(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.Float unk2;
	java.lang.String unk3;
	java.lang.Float unk4;
	Object unk5;
	java.lang.Float unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10015);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
	}
}
