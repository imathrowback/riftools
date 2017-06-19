package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1954 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1954")
public class _1954 extends _999511
{
	public _1954(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1954);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
