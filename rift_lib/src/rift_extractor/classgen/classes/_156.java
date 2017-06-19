package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 156 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_156")
public class _156 
{
	public _156(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	java.lang.Float unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 156);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
	}
}
