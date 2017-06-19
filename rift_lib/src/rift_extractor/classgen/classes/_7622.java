package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7622 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7622")
public class _7622 
{
	public _7622(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	Object unk2;
	java.lang.String unk3;
	ID unk4;
	ID unk5;
	java.lang.String unk6;
	ID unk7;
	ID unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7622);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(ID.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(ID.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(ID.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(ID.class,obj, 8);
	}
}
