package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4441 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4441")
public class _4441 extends _999518
{
	public _4441(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4441);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
