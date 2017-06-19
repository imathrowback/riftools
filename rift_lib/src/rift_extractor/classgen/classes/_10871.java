package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10871 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10871")
public class _10871 
{
	public _10871(){}
	java.lang.Float unk0;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10871);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
	}
}
