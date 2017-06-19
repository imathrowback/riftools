package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4218 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4218")
public class _4218 
{
	public _4218(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_303> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4218);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
