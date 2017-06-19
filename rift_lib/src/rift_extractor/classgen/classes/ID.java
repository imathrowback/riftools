package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7703 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("ID")
public class ID 
{
	public ID(){}
	public java.lang.Integer unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7703);

		unk0 = ClassUtils.getFieldMember(java.lang.Integer.class,obj, 0);
	}
}
