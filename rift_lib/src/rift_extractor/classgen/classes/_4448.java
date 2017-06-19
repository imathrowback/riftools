package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4448 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4448")
public class _4448 extends _999518
{
	public _4448(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4448);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
