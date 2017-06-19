package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3804 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3804")
public class _3804 
{
	public _3804(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	ID unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3804);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
	}
}
