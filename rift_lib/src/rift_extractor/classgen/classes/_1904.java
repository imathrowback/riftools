package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1904 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1904")
public class _1904 extends _999519
{
	public _1904(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1904);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
