package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3880 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3880")
public class _3880 
{
	public _3880(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_3874> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3880);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
