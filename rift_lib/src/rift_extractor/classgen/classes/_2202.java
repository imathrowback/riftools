package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2202 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2202")
public class _2202 extends _999506
{
	public _2202(){}
	ID unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Boolean unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2202);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
	}
}
