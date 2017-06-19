package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2252 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2252")
public class _2252 
{
	public _2252(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2252);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
