package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3022 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3022")
public class _3022 
{
	public _3022(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.Long unk2;
	java.lang.Float unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3022);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 3);
	}
}
