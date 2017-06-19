package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 304 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_304")
public class _304 
{
	public _304(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 304);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
