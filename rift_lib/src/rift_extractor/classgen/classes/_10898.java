package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10898 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10898")
public class _10898 extends _999500
{
	public _10898(){}
	java.lang.Boolean unk0;
	java.util.HashMap<java.lang.Long,_303> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10898);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
