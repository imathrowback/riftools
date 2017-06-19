package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 630 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_630")
public class _630 
{
	public _630(){}
	Object unk0;
	java.util.List<_609> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 630);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.list(_609.class,obj,1);
	}
}
