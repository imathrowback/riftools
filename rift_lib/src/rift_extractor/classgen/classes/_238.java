package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 238 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_238")
public class _238 
{
	public _238(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_307> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 238);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
