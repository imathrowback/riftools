package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7645 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7645")
public class _7645 
{
	public _7645(){}
	ID unk0;
	ID unk1;
	java.lang.String unk2;
	java.lang.Long unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7645);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
	}
}
