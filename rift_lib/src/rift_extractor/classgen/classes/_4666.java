package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 4666 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_4666")
public class _4666 
{
	public _4666(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	java.lang.Long unk2;
	java.lang.Long unk3;
	Object unk4;
	_3525 unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 4666);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(Object.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(_3525.class,obj, 5);
	}
}
