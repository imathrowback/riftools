package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7398 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7398")
public class _7398 
{
	public _7398(){}
	java.lang.Float unk0;
	java.lang.Float unk1;
	java.util.List<_7399> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7398);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.list(_7399.class,obj,2);
	}
}
