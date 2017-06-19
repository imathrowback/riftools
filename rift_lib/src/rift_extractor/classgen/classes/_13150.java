package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 13150 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_13150")
public class _13150 
{
	public _13150(){}
	java.lang.Float unk0;
	java.lang.String unk1;
	java.lang.String unk2;
	java.lang.String unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 13150);

		unk0 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.String.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
	}
}
