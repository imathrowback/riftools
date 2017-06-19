package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 691 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_691")
public class _691 
{
	public _691(){}
	java.lang.String unk0;
	java.util.List<_999519> unk1;
	java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 691);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_999519.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
