package rift_extractor.classgen.classes;
import org.imathrowback.datparser.CObject;
import static rift_extractor.classgen.ClassUtils.*;
import rift_extractor.classgen.ClassUtils;

/** 2246 **/
@com.thoughtworks.xstream.annotations.XStreamAlias("_2246")
public class _2246 
{
	public _2246(){}
	TextEntry unk0;
	java.lang.Long unk1;
	java.lang.Long unk2;

	public void parse(CObject obj)
	{
		ClassUtils.assertType(obj, 2246);

		unk0 = ClassUtils.getFieldMember(TextEntry.class,obj, 0);
		unk1 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 1);
		unk2 = ClassUtils.getFieldMember(java.lang.Long.class,obj, 2);
	}
}
