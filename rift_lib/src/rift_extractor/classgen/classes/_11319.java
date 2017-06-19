package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 11319 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_11319")
public class _11319 
{
	public _11319(){}
	ID unk0;
	java.lang.String unk1;
	java.util.HashMap<java.lang.Long,_306> unk2;
	java.util.HashMap<java.lang.Long,ID> unk3;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 11319);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.String.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 3);
	}
}
