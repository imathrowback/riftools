package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8656 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8656")
public class _8656 
{
	public _8656(){}
	public java.lang.Float unk0;
	public java.lang.Long unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8656);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
	}
}
