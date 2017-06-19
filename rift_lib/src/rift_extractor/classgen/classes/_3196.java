package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3196 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3196")
public class _3196 
{
	public _3196(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.lang.String unk2;
	java.lang.String unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3196);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
	}
}
