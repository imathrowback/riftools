package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3213 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3213")
public class _3213 
{
	public _3213(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	java.util.List<_3212> unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3213);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.list(_3212.class,obj,2);
	}
}
