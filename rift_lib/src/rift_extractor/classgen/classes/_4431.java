package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4431 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4431")
public class _4431 
{
	public _4431(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.util.HashMap<java.lang.Long,_4432> unk1;
	java.lang.Float unk2;
	java.lang.Float unk3;
	java.lang.Float unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;
	java.lang.Float unk7;
	java.lang.Float unk8;
	java.lang.Float unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4431);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 9);
	}
}
