package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1654 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1654")
public class _1654 
{
	public _1654(){}
	Object unk0;
	Object unk1;
	java.lang.Boolean unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1654);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
	}
}
