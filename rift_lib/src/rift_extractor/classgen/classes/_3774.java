package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3774 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3774")
public class _3774 
{
	public _3774(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_3775> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3774);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
