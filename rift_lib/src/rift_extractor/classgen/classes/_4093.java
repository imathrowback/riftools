package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4093 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4093")
public class _4093 
{
	public _4093(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4093);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
