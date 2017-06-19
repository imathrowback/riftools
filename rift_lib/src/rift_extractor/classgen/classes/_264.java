package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 264 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_264")
public class _264 
{
	public _264(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_261> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 264);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
