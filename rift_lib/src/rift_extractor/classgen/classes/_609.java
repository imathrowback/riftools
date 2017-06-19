package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 609 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_609")
public class _609 
{
	public _609(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.Boolean unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 609);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
	}
}
