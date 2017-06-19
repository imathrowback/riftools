package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3739 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3739")
public class _3739 
{
	public _3739(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;
	Object unk3;
	public java.lang.Float unk4;
	public java.lang.Float unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3739);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
	}
}
