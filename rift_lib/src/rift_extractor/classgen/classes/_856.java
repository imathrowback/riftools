package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 856 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_856")
public class _856 
{
	public _856(){}
	java.lang.String unk0;
	java.util.List<_2023> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 856);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_2023.class,obj,1);
	}
}
