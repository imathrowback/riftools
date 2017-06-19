package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11466 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11466")
public class _11466 extends _999569
{
	public _11466(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11466);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
