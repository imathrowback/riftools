package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7733 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7733")
public class _7733 
{
	public _7733(){}
	java.lang.String unk0;
	java.util.List<_7735> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7733);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_7735.class,obj,1);
	}
}
