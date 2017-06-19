package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 307 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_307")
public class _307 
{
	public _307(){}
	public java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 307);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
