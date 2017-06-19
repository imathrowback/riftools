package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 153 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_153")
public class _153 
{
	public _153(){}
	ID unk0;
	ID unk1;
	java.lang.String unk2;
	java.lang.String unk3;
	Object unk4;
	java.lang.String unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 153);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class,obj, 5);
	}
}
