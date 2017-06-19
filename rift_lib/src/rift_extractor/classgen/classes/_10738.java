package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10738 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10738")
public class _10738 extends _999519
{
	public _10738(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10738);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
