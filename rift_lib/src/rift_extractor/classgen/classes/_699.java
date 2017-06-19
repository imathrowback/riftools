package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 699 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_699")
public class _699 extends _999545
{
	public _699(){}
	_3600 unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 699);

		unk0 = ClassUtils.getFieldMember(_3600.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
