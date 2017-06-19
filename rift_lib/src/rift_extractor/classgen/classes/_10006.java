package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10006 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10006")
public class _10006 
{
	public _10006(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.String unk2;
	java.lang.Float unk3;
	Object unk4;
	Object unk5;
	Object unk6;
	Object unk7;
	_10014 unk8;
	_10014 unk9;
	_10014 unk10;
	java.util.HashMap<java.lang.Long,_306> unk11;
	java.util.HashMap<java.lang.Long,_306> unk12;
	java.util.HashMap<java.lang.Long,_306> unk13;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10006);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(_10014.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(_10014.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(_10014.class,obj, 10);
		unk11 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 11);
		unk12 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 12);
		unk13 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 13);
	}
}
