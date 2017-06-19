package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1782 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1782")
public class _1782 extends _999559
{
	public _1782(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1782);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
