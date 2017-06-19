package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4279 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4279")
public class _4279 extends _999517
{
	public _4279(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4279);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
