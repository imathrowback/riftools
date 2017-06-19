package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1992 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1992")
public class _1992 extends _999519
{
	public _1992(){}
	java.lang.Boolean unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1992);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
	}
}
