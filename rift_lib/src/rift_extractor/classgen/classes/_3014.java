package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3014 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3014")
public class _3014 
{
	public _3014(){}
	java.lang.String unk0;
	Object unk1;
	Object unk2;
	java.lang.String unk3;
	java.lang.String unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3014);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(Object.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.String.class,obj, 4);
	}
}
