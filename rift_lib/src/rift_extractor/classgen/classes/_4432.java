package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4432 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4432")
public class _4432 
{
	public _4432(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_4433> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4432);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
