package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10003 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10003")
public class _10003 
{
	public _10003(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.String unk0;
	public java.lang.String unk1;
	public java.lang.String unk2;
	public java.lang.Float unk3;
	public java.lang.String unk4;
	public java.lang.String unk5;
	public java.lang.String unk6;
	public java.lang.String unk7;
	public java.lang.String unk8;
	public java.lang.String unk9;
	public java.lang.String unk10;
	public java.util.List<java.lang.Long> unk11;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10003);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.String.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.String.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.String.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.String.class,obj, 9);
		unk10 = ClassUtils.getFieldMember(java.lang.String.class,obj, 10);
		unk11 = ClassUtils.list(java.lang.Long.class,obj,11);
	}
}
