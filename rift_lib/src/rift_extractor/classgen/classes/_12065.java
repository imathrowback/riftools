package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 12065 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_12065")
public class _12065 extends _999504
{
	public _12065(){}
	java.lang.Float unk0;
	java.util.List<_12071> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 12065);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.list(_12071.class,obj,1);
	}
}
