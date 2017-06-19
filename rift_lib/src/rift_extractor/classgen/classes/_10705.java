package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10705 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10705")
public class _10705 
{
	public _10705(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.List<java.lang.Long> unk0;
	java.util.List<_10731> unk1;
	java.lang.Boolean unk2;
	java.lang.Boolean unk3;
	java.lang.Boolean unk4;
	java.lang.Float unk5;
	java.lang.Float unk6;
	java.lang.Float unk7;
	java.lang.Long unk8;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10705);

		unk0 = ClassUtils.list(java.lang.Long.class,obj,0);
		unk1 = ClassUtils.list(_10731.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
	}
}
