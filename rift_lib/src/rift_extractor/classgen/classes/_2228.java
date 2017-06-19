package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2228 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2228")
public class _2228 
{
	public _2228(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2228);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
