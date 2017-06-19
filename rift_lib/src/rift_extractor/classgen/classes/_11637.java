package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11637 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11637")
public class _11637 
{
	public _11637(){}
	java.lang.String unk0;
	java.util.List<_11621> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11637);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(_11621.class,obj,1);
	}
}
