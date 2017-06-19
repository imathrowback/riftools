package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 893 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_893")
public class _893 
{
	public _893(){}
	ID unk0;
	java.util.List<_898> unk1;
	ID unk2;
	java.lang.Long unk3;
	java.lang.Double unk4;
	java.util.HashMap<java.lang.Long,_676> unk5;
	java.lang.Boolean unk6;
	java.lang.Long unk7;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 893);

		unk0 = ClassUtils.getFieldMember(ID.class,obj, 0);
		unk1 = ClassUtils.list(_898.class,obj,1);
		unk2 = ClassUtils.getFieldMember(ID.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Double.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 7);
	}
}
