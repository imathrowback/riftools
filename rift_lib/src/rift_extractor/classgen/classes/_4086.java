package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4086 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4086")
public class _4086 
{
	public _4086(){}
	java.lang.String unk0;
	java.util.Date unk1;
	java.util.Date unk2;
	java.util.Date unk3;
	Object unk4;
	Object unk5;
	java.util.List<java.lang.Long> unk6;
	java.lang.Boolean unk7;
	java.util.HashMap<java.lang.Long,_4243> unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4086);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.Date.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.Date.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.Date.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.list(java.lang.Long.class,obj,6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 8);
	}
}
