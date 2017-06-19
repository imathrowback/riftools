package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2305 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2305")
public class _2305 
{
	public _2305(){}
	java.lang.String unk0;
	ID unk1;
	ID unk2;
	Object unk3;
	Object unk4;
	java.lang.Long unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2305);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(ID.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
	}
}
