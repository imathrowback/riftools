package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10022 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10022")
public class _10022 
{
	public _10022(){}
	Object unk0;
	java.lang.String unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10022);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
	}
}
