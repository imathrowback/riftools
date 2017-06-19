package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11660 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11660")
public class _11660 
{
	public _11660(){}
	java.lang.String unk0;
	java.util.List<_11658> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11660);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_11658.class,obj,1);
	}
}
