package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 6025 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_6025")
public class _6025 
{
	public _6025(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	ID unk1;
	ID unk2;
	java.lang.Float unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 6025);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
	}
}
