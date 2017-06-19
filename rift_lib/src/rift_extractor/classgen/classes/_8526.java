package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8526 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8526")
public class _8526 
{
	public _8526(){}
	Object unk0;
	Object unk1;
	public java.lang.Boolean unk2;
	public java.lang.Boolean unk3;
	public java.lang.Boolean unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8526);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
	}
}
