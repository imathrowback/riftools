package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2272 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2272")
public class _2272 
{
	public _2272(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2272);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
