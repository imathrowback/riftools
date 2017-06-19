package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 838 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_838")
public class _838 
{
	public _838(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.util.List<java.lang.Long> unk2;
	java.util.List<_837> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 838);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.list(java.lang.Long.class,obj,2);
		unk3 = ClassUtils.list(_837.class,obj,3);
	}
}
