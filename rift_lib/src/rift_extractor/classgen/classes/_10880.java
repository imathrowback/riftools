package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10880 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10880")
public class _10880 
{
	public _10880(){}
	public java.util.List<_10881> unk0;
	Object unk1;
	public java.util.List<_303> unk2;
	public java.lang.Long unk3;
	public java.util.HashMap<java.lang.Long,_304> unk4;
	public java.util.List<_304> unk5;
	Object unk6;
	Object unk7;
	public java.lang.Long unk8;
	public java.lang.Long unk9;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10880);

		unk0 = ClassUtils.list(_10881.class,obj,0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.list(_303.class,obj,2);
		unk3 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 4);
		unk5 = ClassUtils.list(_304.class,obj,5);
		unk6 = ClassUtils.getFieldMember(Object.class,obj, 6);
		unk7 = ClassUtils.getFieldMember(Object.class,obj, 7);
		unk8 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 8);
		unk9 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 9);
	}
}
