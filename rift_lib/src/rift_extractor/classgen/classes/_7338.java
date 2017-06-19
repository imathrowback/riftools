package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7338 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7338")
public class _7338 
{
	public _7338(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7338);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
