package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 8655 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_8655")
public class _8655 
{
	public _8655(){}
	Object unk0;
	Object unk1;
	public TextEntry unk2;
	public _8657 unk3;
	public _8657 unk4;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 8655);

		unk0 = ClassUtils.getFieldMember(Object.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(Object.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(TextEntry.class,obj, 2);
		unk3 = ClassUtils.getFieldMember(_8657.class,obj, 3);
		unk4 = ClassUtils.getFieldMember(_8657.class,obj, 4);
	}
}
