package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2271 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2271")
public class _2271 
{
	public _2271(){}
	java.lang.Boolean unk0;
	java.lang.Float unk1;
	java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2271);

		unk0 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
