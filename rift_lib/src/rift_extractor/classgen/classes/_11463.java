package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11463 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11463")
public class _11463 
{
	public _11463(){}
	java.lang.String unk0;
	java.lang.Boolean unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11463);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
	}
}
