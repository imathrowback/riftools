package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1864 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1864")
public class _1864 
{
	public _1864(){}
	java.lang.Float unk0;
	java.util.List<java.lang.String> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1864);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.String.class,obj,1);
	}
}
