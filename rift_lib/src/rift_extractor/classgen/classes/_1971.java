package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1971 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1971")
public class _1971 
{
	public _1971(){}
	java.lang.String unk0;
	java.lang.Long unk1;
	ID unk2;
	ID unk3;
	java.lang.Float unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1971);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
	}
}
