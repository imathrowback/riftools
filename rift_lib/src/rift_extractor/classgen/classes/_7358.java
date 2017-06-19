package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7358 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7358")
public class _7358 extends _999519
{
	public _7358(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7358);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
