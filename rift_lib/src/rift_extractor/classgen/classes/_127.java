package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 127 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_127")
public class _127 
{
	public _127(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.Long unk1;
	public java.lang.Long unk2;
	public java.lang.Long unk3;
	public java.lang.Long unk4;
	public java.lang.Long unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 127);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
	}
}
