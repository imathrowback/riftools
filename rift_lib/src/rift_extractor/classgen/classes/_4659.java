package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4659 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4659")
public class _4659 
{
	public _4659(){}
	java.lang.String unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4659);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
	}
}
