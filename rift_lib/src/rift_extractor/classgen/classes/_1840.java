package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1840 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1840")
public class _1840 
{
	public _1840(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.util.HashMap<java.lang.Long,_303> unk0;
	java.util.HashMap<java.lang.Long,_303> unk1;
	java.util.HashMap<java.lang.Long,_303> unk2;
	java.util.HashMap<java.lang.Long,_303> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1840);

		unk0 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
	}
}
