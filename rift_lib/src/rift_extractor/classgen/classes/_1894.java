package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1894 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1894")
public class _1894 
{
	public _1894(){}
	public java.lang.Integer unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1894);

		unk0 = ClassUtils.getFieldMember(java.lang.Integer.class,obj, 0);
	}
}
