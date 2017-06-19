package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 269 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_269")
public class _269 
{
	public _269(){}
	java.lang.Float unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 269);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
