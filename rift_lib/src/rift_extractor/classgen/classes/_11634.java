package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11634 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11634")
public class _11634 
{
	public _11634(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.Long unk1;
	public java.lang.Boolean unk2;
	public java.lang.Long unk3;
	public java.lang.Long unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11634);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
	}
}
