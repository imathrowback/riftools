package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8275 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8275")
public class _8275 
{
	public _8275(){}
	java.lang.Boolean unk0;
	java.util.List<java.lang.String> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8275);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.String.class,obj,1);
	}
}
