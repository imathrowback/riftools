package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11331 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11331")
public class _11331 
{
	public _11331(){}
	public java.lang.Float unk0;
	public java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11331);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
