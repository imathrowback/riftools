package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 126 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_126")
public class _126 
{
	public _126(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	public java.lang.String unk0;
	public _51 unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 126);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(_51.class,obj, 1);
	}
}
