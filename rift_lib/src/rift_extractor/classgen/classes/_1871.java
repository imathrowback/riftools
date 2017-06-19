package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1871 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1871")
public class _1871 
{
	public _1871(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_1872> unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1871);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
	}
}
