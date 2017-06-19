package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 843 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_843")
public class _843 
{
	public _843(){}
	java.lang.String unk0;
	java.lang.Float unk1;
	java.lang.Float unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 843);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
	}
}
