package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3508 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3508")
public class _3508 extends _999511
{
	public _3508(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3508);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
