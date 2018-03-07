package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7630 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7630")
public class _7630 
{
	public _7630(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.String unk1;
	public java.lang.String unk2;
	public rift_extractor.classgen.Vector4 unk3;
	public rift_extractor.classgen.Vector4 unk4;
	Object unk5;
	public TextEntry unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7630);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.vector4(obj,3);
		unk4 = ClassUtils.vector4(obj,4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(TextEntry.class,obj, 6);
	}
}
