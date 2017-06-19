package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3919 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3919")
public class _3919 
{
	public _3919(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.Float unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3919);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
	}
}
