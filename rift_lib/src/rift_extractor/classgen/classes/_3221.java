package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3221 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3221")
public class _3221 
{
	public _3221(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_3207> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3221);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
