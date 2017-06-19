package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10900 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10900")
public class _10900 
{
	public _10900(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10900);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
