package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 271 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_271")
public class _271 
{
	public _271(){}
	java.lang.String unk0;
	java.util.List<java.lang.Long> unk1;
	java.lang.Float unk2;
	java.lang.String unk3;
	java.lang.Float unk4;
	java.lang.Float unk5;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 271);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.list(java.lang.Long.class,obj,1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.String.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 5);
	}
}
