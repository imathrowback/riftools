package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4096 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4096")
public class _4096 
{
	public _4096(){}
	Object unk0;
	ID unk1;
	java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4096);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
