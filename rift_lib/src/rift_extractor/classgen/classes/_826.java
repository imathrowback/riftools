package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 826 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_826")
public class _826 extends _999500
{
	public _826(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 826);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
