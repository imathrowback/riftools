package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 253 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_253")
public class _253 
{
	public _253(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.String unk1;
	ID unk2;
	java.lang.Float unk3;
	java.lang.Float unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 253);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
	}
}
