package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 733 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_733")
public class _733 
{
	public _733(){}
	Object unk0;
	java.lang.String unk1;
	java.lang.String unk2;
	java.lang.String unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 733);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
	}
}
