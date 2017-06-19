package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3846 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3846")
public class _3846 
{
	public _3846(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	java.lang.Long unk4;
	java.lang.Long unk5;
	_3525 unk6;
	_3525 unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3846);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(_3525.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(_3525.class,obj, 7);
	}
}
