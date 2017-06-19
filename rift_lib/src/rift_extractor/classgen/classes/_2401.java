package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2401 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2401")
public class _2401 
{
	public _2401(){}
	public java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2401);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
