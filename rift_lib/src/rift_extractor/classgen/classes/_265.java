package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 265 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_265")
public class _265 
{
	public _265(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	Object unk1;
	Object unk2;
	java.util.HashMap<java.lang.Long,_770> unk3;
	java.util.HashMap<java.lang.Long,_770> unk4;
	java.util.HashMap<java.lang.Long,_770> unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 265);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 5);
	}
}
