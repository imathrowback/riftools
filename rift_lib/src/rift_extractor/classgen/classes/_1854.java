package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1854 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1854")
public class _1854 
{
	public _1854(){}
	ID unk0;
	ID unk1;
	ID unk2;
	ID unk3;
	ID unk4;
	ID unk5;
	ID unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1854);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(ID.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(ID.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(ID.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(ID.class,obj, 6);
	}
}
