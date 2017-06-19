package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7650 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7650")
public class _7650 
{
	public _7650(){}
	java.lang.String unk0;
	ID unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7650);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
	}
}
