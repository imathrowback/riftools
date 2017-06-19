package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2241 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2241")
public class _2241 
{
	public _2241(){}
	Object unk0;
	Object unk1;
	java.lang.Long unk2;
	ID unk3;
	ID unk4;
	ID unk5;
	ID unk6;
	java.lang.Boolean unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2241);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(ID.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(ID.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(ID.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 7);
	}
}
