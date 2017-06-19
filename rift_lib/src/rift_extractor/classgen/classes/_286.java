package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 286 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_286")
public class _286 
{
	public _286(){}
	java.lang.Float unk0;
	java.lang.Float unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 286);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
	}
}
