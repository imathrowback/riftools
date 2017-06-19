package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10890 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10890")
public class _10890 
{
	public _10890(){}
	java.lang.String unk0;
	ID unk1;
	java.lang.Boolean unk2;
	java.lang.String unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10890);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
	}
}
