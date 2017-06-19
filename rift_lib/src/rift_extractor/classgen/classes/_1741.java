package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1741 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1741")
public class _1741 extends _999554
{
	public _1741(){}
	ID unk0;
	java.lang.Boolean unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1741);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
	}
}
