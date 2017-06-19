package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4602 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4602")
public class _4602 
{
	public _4602(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.util.HashMap<java.lang.Long,_307> unk0;
	public java.lang.Float unk1;
	public java.lang.Float unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4602);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
	}
}
