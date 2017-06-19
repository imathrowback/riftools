package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7371 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7371")
public class _7371 extends _999519
{
	public _7371(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7371);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
