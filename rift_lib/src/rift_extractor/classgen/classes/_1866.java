package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1866 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1866")
public class _1866 
{
	public _1866(){}
	Object unk0;
	Object unk1;
	Object unk2;
	Object unk3;
	public java.lang.Long unk4;
	Object unk5;
	Object unk6;
	public TextEntry unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1866);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(Object.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(TextEntry.class,obj, 7);
	}
}
