package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11335 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11335")
public class _11335 extends _999503
{
	public _11335(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11335);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
