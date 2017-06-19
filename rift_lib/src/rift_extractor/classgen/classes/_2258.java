package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2258 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2258")
public class _2258 
{
	public _2258(){}
	public java.lang.Boolean unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	public java.lang.Long unk4;
	public java.lang.Long unk5;
	public java.lang.Long unk6;
	public java.lang.Long unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2258);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
	}
}
