package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8276 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8276")
public class _8276 
{
	public _8276(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8276);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
