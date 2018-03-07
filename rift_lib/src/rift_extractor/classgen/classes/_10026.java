package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 10026 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_10026")
public class _10026 
{
	public _10026(){}
	java.lang.String unk0;
	TextEntry unk1;
	java.util.HashMap<java.lang.Long,_10027> unk2;
	Object unk3;
	java.lang.Boolean unk4;
	java.lang.Boolean unk5;
	java.lang.String unk6;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 10026);

		unk0 = ClassUtils.getFieldMember(java.lang.String.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.util.HashMap.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(Object.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
		unk5 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 5);
		unk6 = ClassUtils.getFieldMember(java.lang.String.class,obj, 6);
	}
}
