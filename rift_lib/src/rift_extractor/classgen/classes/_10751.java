package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10751 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10751")
public class _10751 
{
	public _10751(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10751);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
