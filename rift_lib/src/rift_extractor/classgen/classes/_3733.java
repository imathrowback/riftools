package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3733 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3733")
public class _3733 extends _999517
{
	public _3733(){}
	_3600 unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3733);

		unk0 = ClassUtils.getFieldMember(_3600.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
