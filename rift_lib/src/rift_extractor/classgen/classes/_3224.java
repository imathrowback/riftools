package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 3224 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_3224")
public class _3224 
{
	public _3224(){}
	java.lang.String unk0;
	java.lang.String unk1;
	java.util.HashMap<java.lang.Long,_3223> unk2;
	java.util.HashMap<java.lang.Long,_3223> unk3;
	java.util.HashMap<java.lang.Long,_3223> unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 3224);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 4);
	}
}
