package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8661 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8661")
public class _8661 
{
	public _8661(){}
	Object unk0;
	Object unk1;
	java.lang.Boolean unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8661);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
	}
}
