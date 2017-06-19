package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10000 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10000")
public class _10000 
{
	public _10000(){}
	java.util.List<java.lang.String> unk0;
	java.lang.Float unk1;
	java.lang.Float unk2;
	java.util.HashMap<java.lang.Long,_10019> unk3;
	java.util.List<java.lang.String> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10000);

		unk0 = ClassUtils.list(java.lang.String.class,obj,0);
		unk1 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Float.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
		unk4 = ClassUtils.list(java.lang.String.class,obj,4);
	}
}
