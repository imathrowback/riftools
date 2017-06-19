package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11328 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11328")
public class _11328 
{
	public _11328(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	ID unk2;
	ID unk3;
	java.lang.Float unk4;
	java.lang.Long unk5;
	java.lang.Long unk6;
	java.lang.Long unk7;
	java.lang.Long unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11328);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
	}
}
