package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 97 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_97")
public class _97 
{
	public _97(){}
	@com.thoughtworks.xstream.annotations.XStreamAsAttribute
	java.lang.Long unk0;
	java.lang.Boolean unk1;
	TextEntry unk2;
	_314 unk3;
	java.lang.Boolean unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 97);

		unk0 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(_314.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(java.lang.Boolean.class,obj, 4);
	}
}
