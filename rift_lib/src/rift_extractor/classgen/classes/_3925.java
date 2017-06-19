package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3925 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3925")
public class _3925 
{
	public _3925(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;
	public java.lang.Float unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3925);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
	}
}
