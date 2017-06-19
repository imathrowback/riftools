package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 774 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_774")
public class _774 
{
	public _774(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.List<_3507> unk1;
	ID unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 774);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.list(_3507.class,obj,1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
	}
}
