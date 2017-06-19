package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4206 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4206")
public class _4206 
{
	public _4206(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4206);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
