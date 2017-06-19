package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3602 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3602")
public class _3602 
{
	public _3602(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_3603> unk0;
	java.util.HashMap<java.lang.Long,_3592> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3602);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
	}
}
