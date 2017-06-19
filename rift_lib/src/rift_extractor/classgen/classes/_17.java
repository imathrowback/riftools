package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 17 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_17")
public class _17 
{
	public _17(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 17);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
