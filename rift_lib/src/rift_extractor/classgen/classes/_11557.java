package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11557 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11557")
public class _11557 
{
	public _11557(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11557);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
	}
}
