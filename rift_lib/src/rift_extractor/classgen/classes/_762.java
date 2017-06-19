package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 762 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_762")
public class _762 
{
	public _762(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 762);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
