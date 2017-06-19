package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3408 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3408")
public class _3408 
{
	public _3408(){}
	java.lang.Float unk0;
	java.util.List<_3402> unk1;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3408);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.list(_3402.class,obj,1);
	}
}
