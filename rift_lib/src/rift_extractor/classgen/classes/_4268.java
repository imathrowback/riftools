package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4268 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4268")
public class _4268 
{
	public _4268(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_4269> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4268);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
