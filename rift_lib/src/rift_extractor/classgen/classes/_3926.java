package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3926 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3926")
public class _3926 
{
	public _3926(){}
	Object unk0;
	Object unk1;
	public java.lang.Float unk2;
	public java.util.HashMap<java.lang.Long,_307> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3926);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
	}
}
