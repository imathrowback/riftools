package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1932 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1932")
public class _1932 
{
	public _1932(){}
	java.lang.Float unk0;
	java.lang.Long unk1;
	java.lang.Boolean unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1932);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
	}
}
