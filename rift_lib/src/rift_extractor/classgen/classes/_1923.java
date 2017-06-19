package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1923 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1923")
public class _1923 
{
	public _1923(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	java.lang.Float unk2;
	java.lang.Float unk3;
	java.lang.Long unk4;
	java.lang.Boolean unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1923);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
	}
}
