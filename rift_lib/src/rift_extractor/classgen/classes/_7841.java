package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 7841 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_7841")
public class _7841 
{
	public _7841(){}
	Object unk0;
	Object unk1;
	Object unk2;
	public java.lang.Float unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 7841);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
	}
}
