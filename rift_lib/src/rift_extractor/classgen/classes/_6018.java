package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6018 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6018")
public class _6018 
{
	public _6018(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_6019> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6018);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
