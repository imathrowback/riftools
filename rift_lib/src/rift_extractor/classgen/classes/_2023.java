package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2023 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2023")
public class _2023 
{
	public _2023(){}
	java.lang.Float unk0;
	java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2023);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
