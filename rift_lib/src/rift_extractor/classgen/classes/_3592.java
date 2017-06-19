package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3592 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3592")
public class _3592 
{
	public _3592(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_3603> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3592);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
