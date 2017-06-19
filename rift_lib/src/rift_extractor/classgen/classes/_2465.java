package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2465 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2465")
public class _2465 
{
	public _2465(){}
	public java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2465);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
