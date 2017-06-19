package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2205 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2205")
public class _2205 
{
	public _2205(){}
	java.lang.String unk0;
	java.util.List<_2232> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2205);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_2232.class,obj,1);
	}
}
