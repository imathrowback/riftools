package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 316 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_316")
public class _316 
{
	public _316(){}
	public java.lang.Boolean unk0;
	public java.lang.Boolean unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 316);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
	}
}
