package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 887 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_887")
public class _887 
{
	public _887(){}
	java.lang.Double unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 887);

		unk0 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 0);
	}
}
