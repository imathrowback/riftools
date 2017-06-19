package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3927 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3927")
public class _3927 
{
	public _3927(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.util.HashMap<java.lang.Long,_307> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3927);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
