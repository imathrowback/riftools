package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7613 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7613")
public class _7613 
{
	public _7613(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	Object unk2;
	ID unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7613);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
	}
}
