package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10021 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10021")
public class _10021 
{
	public _10021(){}
	Object unk0;
	java.lang.String unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10021);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
	}
}
