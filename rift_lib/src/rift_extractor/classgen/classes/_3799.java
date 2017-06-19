package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3799 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3799")
public class _3799 extends _999519
{
	public _3799(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3799);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
