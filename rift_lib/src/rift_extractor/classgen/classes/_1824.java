package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 1824 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_1824")
public class _1824 
{
	public _1824(){}
	Object unk0;
	TextEntry unk1;
	TextEntry unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 1824);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(TextEntry.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
	}
}
