package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7315 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7315")
public class _7315 extends _999519
{
	public _7315(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7315);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
