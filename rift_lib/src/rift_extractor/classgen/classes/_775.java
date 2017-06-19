package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 775 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_775")
public class _775 
{
	public _775(){}
	java.lang.String unk0;
	ID unk1;
	java.lang.Long unk2;
	ID unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 775);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
	}
}
