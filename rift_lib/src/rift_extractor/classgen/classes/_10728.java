package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10728 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10728")
public class _10728 
{
	public _10728(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;
	public java.lang.Long unk1;
	public java.lang.Float unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10728);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
	}
}
